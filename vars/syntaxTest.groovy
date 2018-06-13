#!/usr/bin/env groovy
def call(syntaxTest){
pipeline {
    agent { node{label 'centos'}}
      stages {
        stage('Build') {
          steps { container('centos')
            echo 'Hello Cray'
            echo $APP
            echo $IMAGE_TAG
          }
        }
      }
  environment {
    APP = ''
    REPOSITORY = ''
    VERSION = 'MyVersion'
    IMAGE_TAG = 'v params.VERSION/params.REPOSITORY-${BUILD_NUMBER}'
  }
 }
}
