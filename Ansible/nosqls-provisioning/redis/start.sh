#!/bin/sh

packer build redis.json
docker run -d -p 6379:6379 redis