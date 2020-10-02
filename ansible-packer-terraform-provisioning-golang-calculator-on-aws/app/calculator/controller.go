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

	result, err := calculate(parseParameter(r))
	resultJSON, _ := json.Marshal(result)

	if err != nil {
		fmt.Fprint(w, err)
	} else {
		fmt.Fprint(w, string(resultJSON))
	}

}

func parseParameter(r *http.Request) (float64, float64, string) {
	n1, _ := strconv.ParseFloat(mux.Vars(r)["num1"], 64)
	n2, _ := strconv.ParseFloat(mux.Vars(r)["num2"], 64)
	op, _ := mux.Vars(r)["operation"]

	return n1, n2, op
}

func historyResponse(w http.ResponseWriter, r *http.Request) {
	result, _ := json.Marshal(Operations)
	fmt.Fprint(w, string(result))
}
