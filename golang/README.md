# Golang implementation #

## Functional Programming paradigm ##

1. First-class functions
: When functions are treated as data type variables and can be used like any other variables. These first-class functions can be passed to functions as parameters, or stored in data structures. 

2. Functional programs try to avoid constructions that produce different outputs on every execution. They make use of recursion

3. Immutability
: In functional programming, we cannot modify a variable after it is created, because we want to maintain the state of the program throughout the runtime of the program. 

4. Pure functions
: They have two major properties: They produce the same output if the given input is the same and they have no side effects. 

5. Higher order functions
: A function that accepts other functions as parameters or returns functions as outputs is called a high order function. This process applies a function to its parameters at each iteration while returning a new function that accepts the next parameter. 

## Closure and Recursion in programming ##

These two form the basis for functional programming in Go. 

What is _Closure_? 
: A function inside a function together with the non-local variables it references is known as closure. The possibility of creating functions inside functions gives way for this paradigm. 

```go
package main

import "fmt"

func main() {
    x := 0
    increment := func() int {
    x++
    return x
}
fmt.Println(increment())
fmt.Println(increment())
}

```
When using closure, the non-local variable persists between calls. 
This is like using generators in python. 

Keywords in Golang: 
```
break        default      func         interface    select
case         defer        go           map          struct
chan         else         goto         package      switch
const        fallthrough  if           range        type
continue     for          import       return       var
```
break -> breaks a loop
case -> swith
chan -> a channel is created using chan keyword 
const -> for declaring constants
continue -> for skipping a loop
default -> for using a default value
defer -> A defer statement defers the execution of a function until the surrounding function returns. 
else -> to use with if statements in conditionals
fallthrough -> With the help of fallthrough statement, we can use to transfer the program control just after the statement is executed in the switch cases even if the expression does not match.
for -> looping construct in golang
func -> declaring functions
go -> 
goto -> This allows you to jump to a labeled statement within the same function.
if -> conditionals
import -> for importing go modules
interface -> 
map -> dictionary creation
package -> package declaration
range -> inbuilt function for arrays, maps and slices -> learn more
return -> returns call to function
select -> 
struct -> record types in golang
switch -> for conditionals based on the value
type -> 
var -> variable declarator



## Pointers in Golang ##

A pointer holds the memroy address of a value. 
Zero value of a pointer is nil.
The type `*T` is a pointer to a T value. 
`var p *int`

`&` operator: It generates a pointer to its operand. 

```
i := 42
p = &i
```
`*` operator the pointer's underlying value. 

[Resume](https://go.dev/tour/moretypes/1)

## Struct ##
A Struct is a collection of fields. 

The fields in a struct are accessed using dot operator. 
They can also be accessed using a struct pointer. 

## Slice ##
The zero value of a slice is `nil`.

[Resume: 20240706](https://go.dev/tour/moretypes/15)