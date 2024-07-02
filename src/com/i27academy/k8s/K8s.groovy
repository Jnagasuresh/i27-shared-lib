package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jekins
    }

    def auth_login(){
        jenkins.sh """
        echo "Entering into Kubernetes Authentication/Login Method"
        gcloud compute instaces list
        """
    }

}