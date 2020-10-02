provider "aws" {}

data "aws_ami" "tema13devops" {
  owners = ["self"]

  filter {
  name   = "name"
  values = ["golang-calculator"]
  }
}

resource "aws_security_group" "security-tema13devops" {
  name        = "security-tema13devops"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_elb" "elb-tema13devops" {
  name               = "elb-tema13devops"
  availability_zones = ["us-east-1a", "us-east-1b", "us-east-1c"]
  security_groups = ["${aws_security_group.security-tema13devops.id}"]

  listener {
  instance_port     = 8080
  instance_protocol = "http"
  lb_port           = 8080
  lb_protocol       = "http"
  }
}

resource "aws_launch_configuration" "lc-tema13devops" {
  name          = "lc-tema13devops"
  image_id      = "${data.aws_ami.tema13devops.id}"
  instance_type = "t2.micro"
}

resource "aws_autoscaling_group" "asg-tema13devops" {
  name                 = "asg-tema13devops"
  availability_zones = ["us-east-1a", "us-east-1b", "us-east-1c"]
  launch_configuration = "${aws_launch_configuration.lc-tema13devops.name}"
  load_balancers = ["${aws_elb.elb-tema13devops.name}"]
  min_size             = 1
  max_size             = 2
}

output "dns-elb" {
  value = "${aws_elb.elb-tema13devops.dns_name}"
}