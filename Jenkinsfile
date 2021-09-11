pipeline {
    agent any

    tools {
        maven "M3"
    }


    stages {
     stage('Test') {
                steps {
                    sh 'mvn test'
                }
                post {
                    always {
                        junit 'target/surefire-reports/*.xml'
                    }
                }
            }
        stage('Build') {
                   steps {
                       sh 'mvn clean package'
                   }
         }
    }
}