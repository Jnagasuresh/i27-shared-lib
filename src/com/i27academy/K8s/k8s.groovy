package com.i27academy.k8s

class k8s {
    def jenkins
    k8s(jenkins){
        this.jenkins = jenkins
    }

    // Authentiction to kubernetes cluster
    def auth_login(){
        jenkins.sh """
        echo "Entering into kubernetes Authentication/login method"
        gcloud auth activate-service-account jenkins@regal-cycling-424510-r6.iam.gserviceaccount.com --key-file=${gke_sa_json}
        """
    }
}