package main

import (
	"net/http"

	"./calculator"
)

func main() {
	calculator.Controller()
	http.ListenAndServe(":8080", calculator.Routes)
}
