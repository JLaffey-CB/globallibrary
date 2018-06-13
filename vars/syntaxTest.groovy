#!/usr/bin/env groovy
def call(String APP, String REPOSITORY){
pipeline {
    agent { node{label 'centos'}}
      stages {
        stage('Build') {
          steps { container('centos')
            {sh '''echo Hello Cray
            env
            echo $APP
            echo $VERSION
            echo $REPOSITORY'''}
          }
        }
      }
  environment {
    VERSION = 'MyVersion'
    IMAGE_TAG = 'v params.VERSION/params.REPOSITORY-${BUILD_NUMBER}'
  }
 }
}
