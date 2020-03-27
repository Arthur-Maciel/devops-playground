## Stress test

### You need to have Jenkins in your PC to setup this project

* Go to your Jenkins dashboard and select new job

* Give it a name like 'stress-test-pipeline'

* Select the 'pipeline' option

* Configuration
    - Go to pipeline section

    - On definition select: Pipeline script from SCM

    - On SCM select: Git

    - URL -> https://github.com/Arthur-Maciel/devops-playground.git

    - Branch specifier: */master

    - On script path put: gatling-stress-test/Jenkinsfile

* Now your pipeline is ready, you just have to run it

* After the execution finish on '/var/lib/jenkins/workspace/pipeline-stress-test-gocalculator/gatling-stress-test/target/gatling/' will have a folder of the execution, when open it, open index.html and check the graphics from the results

* *Note: first execution of the job will take longer than the next ones

* To run the go calculator

    > docker build -t gocalculator .

    > docker run -p 8081:8080 gocalculator

* You can access the calculator on -> http://localhost:8081/calc/[operation]/[num1]/[num2]
