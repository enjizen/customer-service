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
                                sh "mvn sonar:sonar -D sonar.login=admin -D sonar.password=admin1"
                            }
                        }
                    }
                      stage("Quality gate") {
                               timeout(time: 2, unit: 'MINUTES') {
                                          waitForQualityGate abortPipeline: true
                                       }
                            }
        stage('Build') {
                   steps {
                       sh 'mvn -B -DskipTests clean package'
                   }
         }
    }
}