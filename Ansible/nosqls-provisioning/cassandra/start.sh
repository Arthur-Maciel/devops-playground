#!/bin/sh

packer build cassandra.json
docker run -d cassandra