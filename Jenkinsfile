pipeline {
    agent any   // Usa cualquier agente disponible (en Render solo tienes el master)

    stages {
        stage('Build') {
            steps {
                echo "Compilando el proyecto..."
                sh 'echo "Simulando build"'
            }
        }

        stage('Test') {
            steps {
                echo "Ejecutando pruebas..."
                sh 'echo "Simulando pruebas unitarias"'
            }
        }

        stage('Deploy') {
            steps {
                echo "Desplegando aplicación..."
                sh 'echo "Simulando despliegue exitoso 🚀"'
            }
        }
    }

    post {
        success {
            echo "Pipeline ejecutado correctamente ✅"
        }
        failure {
            echo "Pipeline falló ❌"
        }
    }
}
