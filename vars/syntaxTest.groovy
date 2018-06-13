#!/usr/bin/env groovy
def call(syntaxTest){
pipeline {
    agent { node{label 'centos'}}
    stages {
    stage('Build') {
            steps { container('centos')
      echo $APP
      echo $IMAGE_TAG
      }
    }
  }
  parameters {
    string(name: 'APP', defaultValue: '', description: '')
    string(name: 'REPOSITORY', defaultValue: '', description: '')
    string(name: 'VERSION', defaultValue: "MyVersion", description: '')
    string(name: 'IMAGE_TAG', defaultValue: "v params.VERSION/$REPOSITORY-${BUILD_NUMBER}", description: '')
  }
 }
}
