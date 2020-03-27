#!/bin/bash

sudo cp ~/.kube/config ~jenkins/.kube/
sudo chown -R jenkins: ~jenkins/.kube/
sudo chmod 644 ~/.minikube/client.key