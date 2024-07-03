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

    // Kubernetes Deployment
    def k8sdeploy(fileName, namespace){
        jenkins.sh """
        echo "Executing K8s deploy method"
        sudo kubectl apply -f ./.cicd/$fileName -n $namespace
        """
    }

}
