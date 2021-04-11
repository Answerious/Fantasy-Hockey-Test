package main
//#include <unistd.h>
//#include <stdlib.h>
import "C"
import (
	"strconv"
)

//export Goalies
func Goalies(x int) string {
	max := x
	str := "MAX_GOALIES = "
	concatenated := str + strconv.Itoa(max)
	//msg := fmt.Sprintf("MAX_GOALIES = %d", num)
    return concatenated
}
//export Defence
func Defence(x int) int{
	MAX_DEFENCE := 4
	return MAX_DEFENCE*x
}
//export Offence
func Offence(x int) int{
	MAX_OFFENCE := 6
	return MAX_OFFENCE*x
}
//export Team
func Team(x int) int{
	MAX_TEAMSIZE := 12
	return MAX_TEAMSIZE*x
}
func main(){}