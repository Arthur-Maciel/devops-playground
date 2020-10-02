package calculator

import "errors"

var Operations []*operation

type operation struct {
	Num1   float64 `json:"number1"`
	Signal string  `json:"operation"`
	Num2   float64 `json:"number2"`
	Result float64 `json:"result"`
}

func calculate(number1 float64, number2 float64, operator string) (*operation, error) {
	m := map[string]*operation{
		"sum": {Num1: number1, Num2: number2, Signal: "+", Result: number1 + number2},
		"sub": {Num1: number1, Num2: number2, Signal: "-", Result: number1 - number2},
		"mul": {Num1: number1, Num2: number2, Signal: "*", Result: number1 * number2},
		"div": {Num1: number1, Num2: number2, Signal: "/", Result: number1 / number2},
	}

	if op, ok := m[operator]; ok {
		if operator == "div" && number2 == 0 {
			return nil, errors.New("Cannot do a division by zero")
		}
		result := op
		Operations = append(Operations, result)
		return result, nil
	}

	return nil, errors.New("Invalid operation")
}
