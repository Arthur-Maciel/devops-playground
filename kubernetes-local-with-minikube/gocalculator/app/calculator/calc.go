package calculator

var Operations []*operation

type operation struct {
	Num1   float64 `json:"number1"`
	Signal string  `json:"operation"`
	Num2   float64 `json:"number2"`
	Result float64 `json:"result"`
}

func sum(number1 float64, number2 float64) *operation {
	result := &operation{Num1: number1, Num2: number2, Signal: "+", Result: number1 + number2}
	Operations = append(Operations, result)
	return result
}

func sub(number1 float64, number2 float64) *operation {
	result := &operation{Num1: number1, Num2: number2, Signal: "-", Result: number1 - number2}
	Operations = append(Operations, result)
	return result
}

func mul(number1 float64, number2 float64) *operation {
	result := &operation{Num1: number1, Num2: number2, Signal: "*", Result: number1 * number2}
	Operations = append(Operations, result)
	return result
}

func div(number1 float64, number2 float64) *operation {
	result := &operation{Num1: number1, Num2: number2, Signal: "/", Result: number1 / number2}
	Operations = append(Operations, result)
	return result
}
