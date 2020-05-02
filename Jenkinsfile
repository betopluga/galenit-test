pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
   
    environment {
        pom = readMavenPom file: 'backend/pom.xml'
        version_backend = "${pom.version}"
        file = "backend-${pom.version}"
    }

    stages {
        stage('Build') {
            steps {
             
                // Get some code from a GitHub repository
                git 'https://github.com/betopluga/galenit-test'
 
                // Run Maven on a Unix agent.
                sh '''
                cd backend
                mvn -Dmaven.test.failure.ignore=true clean package
                '''
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    //junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'backend/target/' + env.file + '.jar'
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose down --remove-orphans'
                sh 'docker-compose build --build-arg VERSION=' + env.version_backend
                sh 'docker-compose up -d'
            }
        }
    }
}
