#!/bin/bash

curl --header "X-Vault-Token: $1" \
--request POST \
--data @newsecret.json \
http://localhost:8200/v1/secret/data/mysecrets