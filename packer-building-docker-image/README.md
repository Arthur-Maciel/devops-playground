## Jenkins and Packer

### Bake and launch go calculator microservice

### First of all you have to have jenkins, packer and docker in your machine

* Create a credential on Jenkins for git (can be Username/Password if using http to clone repository or with SSH key cloning with ssh)

* Create bake pipeline:
    - On Jenkins dashboard click on 'new job'
    - Give it a name and select pipeline
    - Go to pipeline section:
        - Select on definition: Pipeline script from SCM
        - On SCM select: Git
        - On repository URL put: https://github.com/Arthur-Maciel/devops-playground.git
        - Select your git credential
        - On branch specifier: */master
        - Script path: packer-building-docker-image/bake/Jenkinsfile

* Create launch pipeline:
    - On Jenkins dashboard click on 'new job'
    - Give it a name and select pipeline
    - Go to pipeline section:
        - Select on definition: Pipeline script from SCM
        - Select git
        - On URL put: https://github.com/Arthur-Maciel/devops-playground.git
        - Select your git credential
        - Branch: */master
        - packer-building-docker-image/launch/Jenkinsfile

* Now you can run bake to build docker image and launch to start the go calculator

* The calculator should be on: http://localhost:8081/calc/[operation]/[num1]/[num2]

* Operations:
    - sum
    - sub
    - div
    - mul

