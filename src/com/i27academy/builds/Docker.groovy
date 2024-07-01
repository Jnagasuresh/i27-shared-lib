package com.i27academy.builds

class Docker {
    def jenkins
    Docker(jenkins) {
        this.jenkins = jenkins
    }

    // Applicaiton Build
    def buildApp(appName){
        jenkins.sh """
        echo "Building the Maven for $appName application using Shared library"
        mvn clean package -DskipTests=true
        """
    }
    // Docker Build

    // Docker login

    // Docker Push
    
}