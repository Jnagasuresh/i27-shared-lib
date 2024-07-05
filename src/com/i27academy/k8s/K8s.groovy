package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }

    def auth_login(gke_cluster_name, gke_zone, gke_project){
        jenkins.sh """
        echo "Entering into Kubernetes Authentication/Login Method"    
        sudo gcloud compute instances list      
        sudo gcloud container clusters get-credentials $gke_cluster_name --zone $gke_zone --project $gke_project  
        # sudo gcloud container clusters get-credentials cart-cluster --zone us-west1-a --project regal-cycling-424510-r6  
        echo "******************* Get Nodes in the Cluster ********************************"
        sudo kubectl get nodes
        """
    }

    //  Kubernetes Deployment
    def k8sdeploy(fileName, namespace, docker_image){
        jenkins.sh """
        echo "Executing K8s deploy method"
        sed -i "s|DIT|${docker_image}|g" ./.cicd/$fileName
        sudo kubectl apply -f ./.cicd/$fileName -n $namespace
        """
    }

    // Helm Deployment
    def k8sHelmChartDeploy(appName, env, helmChartPath, imageTag){
        jenkins.sh """
        echo "********************** Executing Helm Groovy Method*****************"
        sudo helm version
        echo " Verify if Chart already exists---------"
        if helm list | grep -q "${appName}-${env}-chart"; then
            echo "This Chart already exists"
            echo " Upgrading the chart !!!!"
            sudo helm upgrade ${appName}-${env}-chart -f ./.cicd/k8s/values_${env}.yaml --set image.tag=${imageTag} ${helmChartPath}
        else 
            echo "******Chart does not exists*****************"
            echo "********************** Installing the chart*****************"
            sudo helm install ${appName}-${env}-chart -f ./.cicd/k8s/values_${env}.yaml --set image.tag=${imageTag} ${helmChartPath}
        fi
        """
    }

    // Clone the repo
    def gitClone() {
        jenkins.sh """
        echo "*************** Executing Git Clone Groovy Method *******************"
        sudo git clone -b main https://github.com/Jnagasuresh/i27-shared-lib.git
        echo "*************** Listing the files after clone *******************"
        """
    }


}
