#!/usr/bin/env groovy
def call(Map args){
pipeline {
    agent { node{label 'centos'}}
      stages {
        stage('Build') {
          steps { container('centos')
            {sh '''echo Hello Cray
            echo $APP
            echo $VERSION
            echo $REPOSITORY
            echo $IMAGE_TAG'''}
          }
        }
      }
  environment {
    VERSION = '1.7.2'
    IMAGE_TAG = "v${VERSION}/${repo}-${BUILD_NUMBER}"
  }
 }
}
