pipeline {
    agent any

    tools {
        maven 'Maven 3.13.0'
        jdk 'JDK17'
    }

    stages {
        stage ('Checkout') {
            steps {
                git 'https://github.com/yogeshb27/UIAutomationFramework.git'
            }
        }

        stage ('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage ('Allure Report Generation') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }

        stage('Publish TestNG Reports') {
            steps {
                // Generate TestNG reports
                publishTestNGReports testResultsPattern: 'target/test-output/testng-results.xml'
            }
        }
    }

    post {
        failure {
            // Notify if the build fails
            mail to: 'yogeshbh27@example.com',
                    subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Please check Jenkins for more details."
        }
    }
}