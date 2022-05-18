 job('example') {
  steps {
    shell('echo Hello')
    }
}

windowsNode = 'windows'

pipeline {
  agent none
  stages {
    stage('Stage 1') {
      agent {
        label windowsNode
      }
      steps {
        script {
          // all subsequent steps should be run on the same windows node
          windowsNode = NODE_NAME
        }
        echo "windowsNode: $windowsNode, NODE_NAME: $NODE_NAME"
      }
    }
    stage('Stage 2') {
      agent {
        label windowsNode
      }
      steps {
        echo "windowsNode: $windowsNode, NODE_NAME: $NODE_NAME"
      }
    }
  }
}
