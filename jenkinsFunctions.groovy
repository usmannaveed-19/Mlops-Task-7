def checkoutCode(String repoUrl, String branch) {
    checkout([$class: 'GitSCM', branches: [[name: branch]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: repoUrl]]])
}

def buildProject() {
    echo 'Building'
    sh 'pip install -r requirements.txt'
}

def runTests() {
    echo 'Test'
    sh 'python3 test.py'
}

def deployApplication() {
    echo 'Deploy'
}

return this
