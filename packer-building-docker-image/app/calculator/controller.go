package calculator

import (
	"encoding/json"
	"fmt"
	"net/http"
	"strconv"

	"github.com/gorilla/mux"
)

var Routes = mux.NewRouter()

func Controller() {
	calcRequest := Routes.PathPrefix("/calc").Subrouter()
	calcRequest.HandleFunc("/{operation}/{num1}/{num2}", callOperation)
	calcRequest.HandleFunc("/history", historyResponse)
}

func callOperation(w http.ResponseWriter, r *http.Request) {
	var op = mux.Vars(r)["operation"]
	var num1, _ = strconv.ParseFloat(mux.Vars(r)["num1"], 64)
	var num2, _ = strconv.ParseFloat(mux.Vars(r)["num2"], 64)

	switch op {
	case "sum":
		result, _ := json.Marshal(sum(num1, num2))
		fmt.Fprint(w, string(result))
	case "sub":
		result, _ := json.Marshal(sub(num1, num2))
		fmt.Fprint(w, string(result))
	case "mul":
		result, _ := json.Marshal(mul(num1, num2))
		fmt.Fprint(w, string(result))
	case "div":
		if num2 == 0 {
			w.WriteHeader(http.StatusInternalServerError)
			fmt.Fprint(w, "Cannot do a division by 0")
			return
		}
		result, _ := json.Marshal(div(num1, num2))
		fmt.Fprint(w, string(result))
	default:
		fmt.Fprint(w, "Invalid opration")
	}
}

func historyResponse(w http.ResponseWriter, r *http.Request) {
	result, _ := json.Marshal(Operations)
	fmt.Fprint(w, string(result))
}
