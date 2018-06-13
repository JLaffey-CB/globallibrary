#!/usr/bin/env groovy
def call(String REPOSITORY, String IMAGE_PREFIX, String APP){
pipeline {
    agent { node{label 'centos'}}
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
    VERSION = 'MyVersion'
    IMAGE_TAG = 'v' + $VERSION + '/' $REPOSITORY + '-' $BUILD_NUMBER
  }
 }
}
