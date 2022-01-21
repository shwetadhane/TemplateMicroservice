pipeline {

    environment {
        dockerimagename = 'pradnyilk/template-microservice'
        dockerImage = ""
    }

    agent any
    stages {
        stage('Checkout Source') {
            steps {
                git 'https://github.com/shwetadhane/TemplateMicroservice.git'
            }
        }
        // stage('Docker Build Image'){
        //     steps{
        //         script{
        //                 withDockerContainer(image: 'pradnyilk/template-microservice', toolName: 'docker',args: 'docker run') {
        //                     // some block
        //                 }
        //         }
        //     }
        // }

        stage('Deploy App to Kubernetes') {
            steps{
                script {
                    kubernetesDeploy( configs: "deployement.yaml", kubeconfigId: "k8s")
                    kubernetesDeploy( configs: "servcie.yaml", kubeconfigId: "k8s")
                }
            }
        }
    }
}