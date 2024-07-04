package golearn

import "fmt"

func F() {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Recovered in f", r)
		}
	}()
	fmt.Println("Calling g.")
	G(0)
	fmt.Println("Returned normally from g.")
}

func G(i int) {
	if i > 3 {
		fmt.Println("Panicking!")
		panic("This is the panic keyword")
	}
	defer fmt.Println("Defer in g", i)
	fmt.Println("Printing in g", i)
	G(i + 1)
}
