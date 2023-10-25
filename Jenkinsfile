def installPythonDependencies() {
    sh '''
        python3 -m venv venv
        source venv/bin/activate
        pip install -r requirements.txt
    '''
}

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out the Git repository
                script {
                    checkout scm
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                // Call the function to install Python dependencies
                script {
                    installPythonDependencies()
                }
            }
        }

        stage('Run Tests') {
            steps {
                // Run your Python test script
                sh 'python test.py'
            }
        }
    }

    post {
        success {
            // This block is executed if the pipeline is successful
            echo 'Pipeline completed successfully'
        }
        failure {
            // This block is executed if the pipeline fails
            echo 'Pipeline failed'
        }
    }
}