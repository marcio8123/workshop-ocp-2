 node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'workshop-ocp', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Deseja realizar a atualização????'
        openshiftDeploy(deploymentConfig: 'workshop-ocp')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5 
    }
}
