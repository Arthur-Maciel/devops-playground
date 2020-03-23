#!/bin/sh

packer build elastic.json
docker run -d elasticsearch