pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/jhonnnier/us-usuarios.git', branch: 'master'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Run App') {
            steps {
                sh 'nohup java -jar target/*.jar &'
            }
        }
    }
}
