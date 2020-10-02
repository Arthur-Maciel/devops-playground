# AWS

## Bake an image and launch a machine with golang calculator

### Necessary softwares:

- Packer

- Terraform

Firsts steps:

- Login on aws console

- On ec2 menu go to key pairs

- Create a new key pair with name `tema13devops`, it will be downloaded a file .pem on Downloads

- Copy the path to file .pem and paste on the json on `ssh_private_key_file`

- export environment varaibles:
    > export AWS_ACCESS_KEY_ID="anaccesskey"

    > export AWS_SECRET_ACCESS_KEY="asecretkey"
    
    > export AWS_DEFAULT_REGION="us-east-1"

Bake ami image:

- On project directory run:
    > packer build build-ami-image.json

Launch instance with infrastructure config:

- Run:
    > terraform init && terraform apply

Start golang calculator:

- Go to the directory where the file .pem is and run:
    > ssh -i {keypair} ec2-user@{instance-ip}

- Instance ip is found on ec2 instances, select your instance if there is more than one and copy the public ip

- Now you are on the machine terminal and run to start the calculator:
    > ./app/main

Access:

- With the public ip, put it on your browser, like this:

    - instance-ip:8080/calc

- Examples:

        instance-ip:8080/calc/sum/1/1
        instance-ip:8080/calc/sub/5/3
        instance-ip:8080/calc/mul/2/2
        instance-ip:8080/calc/div/8/1

To stop the machine and delete all the infra:

- Run:
    > terraform destroy