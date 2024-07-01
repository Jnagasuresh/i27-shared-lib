package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins){
        this.jenkins = jenkins
    }

    // Authentiction to kubernetes cluster
    def auth_login(){
        jenkins.sh """
        echo "Entering into kubernetes Authentication/login method"
        gcloud compute instances list
        """
    }
}