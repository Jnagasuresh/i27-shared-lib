package com.i27academy.k8s

class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }

    def auth_login(){
        jenkins.sh """
        echo "Entering into Kubernetes Authentication/Login Method"
        gcloud config set account jenkins@regal-cycling-424510-r6.iam.gserviceaccount.com
        # gcloud auth activate-service-account jenkins@regal-cycling-424510-r6.iam.gserviceaccount.com --key-file=key.json
        gcloud compute instances list
        gcloud container clusters get-credentials cart-cluster --zone us-west1-a --project regal-cycling-424510-r6
        """
    }

}