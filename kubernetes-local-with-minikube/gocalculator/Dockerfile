FROM golang:latest

ADD app ./app

RUN go get -d ./...
RUN cd app && go build -o main .

EXPOSE 8081

ENTRYPOINT [ "app/main" ]