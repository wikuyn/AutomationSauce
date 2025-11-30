pipeline {
    agent any

    stages {
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
            dir('AutomationSauceDemo') {
                sh 'docker-compose down || true'
            }
        }
    }
}
