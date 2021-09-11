pipeline {
    agent any

    tools {
        maven "M3"
    }


    stages {
     stage('Unit Test') {
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
                       sh 'mvn -B -DskipTests clean package'
                   }
         }
    }
}