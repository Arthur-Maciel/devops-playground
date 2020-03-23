#!/bin/sh

packer build kafka.json
docker run -d -p 9092:9092 kafka