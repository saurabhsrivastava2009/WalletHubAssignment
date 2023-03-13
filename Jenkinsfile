pipeline {
  agent any
  tools {
    maven 'M2_Home' 
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
