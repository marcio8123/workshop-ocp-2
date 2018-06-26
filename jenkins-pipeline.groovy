 node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'workshop-ocp', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Aprova ai PEPA-PIG'
        openshiftDeploy(deploymentConfig: 'workshop-ocp')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5 
    }
}
