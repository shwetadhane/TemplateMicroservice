pipeline {

  options {
    ansiColor('xterm')
  }
    environment {
        dockerimagename = 'pradnyilk/template-microservice'
        dockerImage = ""
    }
    tools{
        maven 'maven'
    }

        // agent{
        //     docker {
        //         image 'pradnyilk/template-microservice'
        //     }
        // }
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
        stage ('Build') {
            steps {
                sh 'mvn -DskipTests=true clean install'
            }
        }
/*         stage('Deploy App to Kubernetes') {
            steps{
                script {
                    kubernetesDeploy( configs: "deployement.yaml", kubeconfigId: "k8s")
                    kubernetesDeploy( configs: "servcie.yaml", kubeconfigId: "k8s")
                }
            }
        } */
        stage('Rollout Latest changes to k8s') {
            steps{
                withKubeConfig([credentialsId: 'jenkins-robot-global']) {
                    sh 'curl -LO "https://storage.googleapis.com/kubernetes-release/release/v1.20.5/bin/linux/amd64/kubectl"'
                    sh 'chmod u+x ./kubectl'
                    sh './kubectl apply -f deployment.yaml'
                    sh './kubectl apply -f servcie.yaml'
                    sh './kubectl rollout restart deployment template-microservice -n default'
                    // sh './kubectl get pods'
                }
            }
          }
        // stage('Apply Kubernetes files') {
        //         steps{
        //             withKubeConfig([credentialsId: 'jenkins-robot', serverUrl: 'https://api.k8s.my-company.com']) {
        //               sh 'kubectl apply -f my-kubernetes-directory'
        //             }
        //         }
        //   }
    //   stage('Deploy Dev') {

    //           steps {
    //                     container('kubectl') {
    //                       // Create namespace if it doesn't exist
    //                       sh("kubectl get pods")
    //                     }
    //         }
    //   }
    }
}