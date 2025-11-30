pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                sh 'ls -lah'        // debug, lihat apakah pom.xml & docker-compose.yml ada
            }
        }

        stage('Run Selenium Tests with Docker') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up --build --abort-on-container-exit'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down || true'
        }
    }
}
