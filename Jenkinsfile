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
                dir('AutomationSauceDemo') {
                    sh 'docker-compose down || true'
                    sh 'docker-compose up --build'
                }
            }
        }
    }

    post {
        always {
            node {
                dir('AutomationSauceDemo') {
                    sh 'docker-compose down || true'
                }
            }
        }
    }
}
