package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }

    def auth_login(){
        jenkins.sh """
        echo "Entering into Kubernetes Authentication/Login Method"    
        sudo gcloud compute instances list      
        sudo gcloud container clusters get-credentials cart-cluster --zone us-west1-a --project regal-cycling-424510-r6  
        echo "******************* Get Nodes in the Cluster ********************************"
        sudo get nodes
        """
    }
}
