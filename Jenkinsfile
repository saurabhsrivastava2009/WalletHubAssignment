pipeline {
  agent any
  tools {
    maven '${M2_HOME}'
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage ('Test') {
      steps {
        script {
          sh 'mvn -Dtest=testTestInsurancePageReviewPosted'
        }
      }
    }
  }
}
