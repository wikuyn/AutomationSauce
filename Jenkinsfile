pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Selenium Tests with Docker') {
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up --build --abort-on-container-exit'
            }
        }
    }

    post {
        always {
            sh 'docker compose down'
        }
    }
}
