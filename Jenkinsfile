pipeline {
    agent any

    environment {
        // Aquí defines variables globales
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    tools {
        // Usa Maven y JDK configurados en Jenkins (Manage Jenkins -> Global Tool Configuration)
        maven "Maven3"
        jdk "JDK11"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/jhonnnier/us-usuarios.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Run App') {
            steps {
                // mata procesos previos en el puerto 8080 para evitar conflictos
                sh 'fuser -k 8080/tcp || true'
                sh 'nohup java -jar target/*.jar > app.log 2>&1 &'
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline ejecutado correctamente. Aplicación desplegada en http://localhost:8080"
        }
        failure {
            echo "❌ Falló el pipeline. Revisa los logs."
        }
    }
}
