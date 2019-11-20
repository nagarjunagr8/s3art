pipeline {
    agent any

    tools {
        maven "Default"
    }
    stages {
        stage('build and package') {
            steps {
                git branch: 'master', credentialsId: 's3art', url: 'git@github.com:nagarjunagr8/s3art.git'
                bat 'mvn clean package'
            }
        }

        stage('upload to s3') {
            steps {
                withAWS(region: 'ap-south-1', credentials: 'aws-user') {
                    s3Upload acl: 'BucketOwnerFullControl', bucket: 'prashanth-bucket1', file: 'cicd.war', workingDir: 'target'
                }
            }

        }

        stage('download from s3') {
            steps {
                dir('deploy') {
                    withAWS(region: 'ap-south-1', credentials: 'aws-user') {
                        s3Download bucket: 'prashanth-bucket1', file: '', force: 'true'
                    }
                }
            }
        }

        stage('deploy to tomcat') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'tomcat-manager-script', path: '', url: 'http://localhost:8080')], contextPath: null, onFailure: false, war: 'deploy/cicd.war'
            }
        }
    }
}