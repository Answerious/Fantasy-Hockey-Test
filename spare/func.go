package main
import "C"
//export fun
func fun(x int,y int) int{
    return x+y+0
}
func main(){}