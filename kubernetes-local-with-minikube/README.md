## Using local Kubernetes with kubectl and minikube

### Requirements:

    - Virtualbox
    - Minikube
    - Kubectl
    - Jenkins
    - Docker

* The docker image from gocalculator is already on docker hub, but if you want to let the image in your docker hub you will need docker

* After installing all the requirements follow this order:

    - 1: Execute allow-jenkins.sh (with root privilege or sudo), with this script jenkins will be able to execute kubectl commands

    - 2: Start minikube: 
        > minikube start

        Note: executing just ``minikube start`` it will choose a deafult vm driver in this cause it should bt virtualbox, but if you have more than one you can choose which one you want or even none (but with none you will have to execute with sudo), the command to choose the vm driver:
        > minikube start --vm-driver=<driver_name>

    - 3: Create your github credential on Jenkins

    - 4: Create jenkins job

        - Click on new job, give it a name and select pipeline

        - Go to pipeline section and select ``Pipeline script from SCM``

        - Choose ``git``

        - Repository URL: ``https://github.com/Arthur-Maciel/devops-playground.git``

        - Put your credentials that you created before

        - On branch put: ``*/master``

        - Script path: ``kubernetes/kubernetes-local-wtih-minikube/Jenkinsfile``

* Now you can execute the job and then open a terminal and execute the commands below to check:

    > kubectl get po

    > kubectl get svc