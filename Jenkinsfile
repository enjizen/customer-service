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
             stage('SonarQube analysis') {
                        steps {
                            withSonarQubeEnv('SonarQube') {
                                sh "mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=admin1"
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