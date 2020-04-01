#!/bin/bash

curl --header "X-Vault-Token: s.3Y59pveAHZ0gXAiYJdSXBvfB" \
--request GET \
http://localhost:8200/v1/secret/data/mysecrets