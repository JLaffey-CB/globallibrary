#!/usr/bin/env groovy
def call(String APP, String REPOSITORY){
pipeline {
    agent { node{label 'centos'}}
      stages {
        stage('Build') {
          steps { container('centos')
            echo 'Hello Cray'
            echo $APP
            echo $REPOSITORY
          }
        }
      }
  environment {
    VERSION = 'MyVersion'
    IMAGE_TAG = 'v params.VERSION/params.REPOSITORY-${BUILD_NUMBER}'
  }
 }
}
