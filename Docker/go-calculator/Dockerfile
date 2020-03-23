FROM golang:latest

ADD app ./app/

RUN go get -d ./...
RUN cd app && go build -o gocalculator .

EXPOSE 8080

ENTRYPOINT [ "./app/gocalculator" ]