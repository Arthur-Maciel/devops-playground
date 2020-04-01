#!/bin/bash

curl --header "X-Vault-Token: s.3Y59pveAHZ0gXAiYJdSXBvfB" \
--request POST \
--data @newsecret.json \
http://localhost:8200/v1/secret/data/mysecrets