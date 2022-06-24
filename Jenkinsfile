pipeline {
    agent any
    tools{
        maven 'MAVEN'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/srjk18/Simplilearn_Phase-5']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t studentmang/spring_jpa-0.0.1-SNAPSHOT .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                  withCredentials([string(credentialsId: 'dock_pwd', variable: 'dockhubpwd')]) {
                  sh 'docker login -u srjk18 -p ${dockhubpwd}'

}
                  sh 'docker push studentmang/spring_jpa-0.0.1-SNAPSHOT'
                }
            }
        }
    }
}