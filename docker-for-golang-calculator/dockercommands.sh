#!/bin/bash
build_microservice () {
    docker build -t gocalculator .
}
start_microservice () {
    docker run --rm -d -p 8080:8080 --name gocalculator gocalculator
}
stop_microservice () {
    docker stop gocalculator
}
status_microservice () {
    docker=$1
    docker_container_name=$(docker ps -q --filter name=$docker)

    if [[ ! -z "$docker_container_name" && $(docker inspect -f '{{.State.Running}}' $docker) = "true" ]]
    then 
        echo "RUNNING"
    else 
        echo "NOT RUNNING"
    fi
}