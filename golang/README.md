# Golang implementation #

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