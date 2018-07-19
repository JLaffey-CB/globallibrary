#!/usr/bin/env groovy
def call(String REPOSITORY, String IMAGE_PREFIX, String APP){
pipeline {
    agent { node{label 'centos-7'}}
      stages {
        stage('Build') {
          steps { container('centos')
            {sh '''echo Hello Cray
            echo $app
            echo $VERSION
            echo $repo
            echo $IMAGE_TAG'''}
          }
        }
      }
  environment {
    repo = "$REPOSITORY"
    image = "$IMAGE_PREFIX"
    app = "$APP"
    VERSION = '1.7.2'
    IMAGE_TAG = "v${VERSION}/${repo}-${BUILD_NUMBER}"
  }
 }
}
