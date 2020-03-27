FROM alpine:3.7

RUN apk update && apk upgrade
RUN apk add openrc collectd collectd-network
RUN apk add --no-cache git make musl-dev go

ADD app usr/local/app

RUN go get github.com/gorilla/mux 
RUN go build usr/local/app/main.go

COPY ./app/config/collectd.conf etc/collectd/collectd.conf
COPY app/config/start.sh /start.sh

RUN chmod +x start.sh

EXPOSE 8080

ENTRYPOINT [ "./start.sh" ]