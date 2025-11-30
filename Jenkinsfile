pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Run Selenium Tests with Docker') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up --build'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down || true'
        }
    }
}
