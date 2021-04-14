package main

import "C"

import (
	"fmt"
	"strconv"
	"os"
	"log"
)
/*
func main() {
	num := 1
	email := "bob@example.com"
	concatenated := strconv.Itoa(num) + email

	fmt.Println(concatenated)
}
*/
//export num
func num(x int) int{
	return x
}
//export Goalies
func Goalies() string{
	max := num(2)
	str := "MAX_GOALIES = "
	concatenated := str + strconv.Itoa(max)
	return concatenated
}
//export Defence
func Defence() string{
	max := num(4)
	str := "MAX_DEFENCE = "
	concatenated := str + strconv.Itoa(max)
	return concatenated
}
//export Offence
func Offence() string{
	max := num(6)
	str := "MAX_OFFENCE = "
	concatenated := str + strconv.Itoa(max)
	return concatenated
}
//export TeamSize
func TeamSize() string{
	max := num(12)
	str := "MAX_TEAM_SIZE = "
	concatenated := str + strconv.Itoa(max)
	return concatenated
}
//export GoalieR
func GoalieR(){
	x := Goalies()
	fmt.Println(x)
	return
}
//export DefenceR
func DefenceR(){
	x := Defence()
	fmt.Println(x)
	return
}
//export OffenceR
func OffenceR(){
	x := Offence()
	fmt.Println(x)
	return
}
//export TeamSizeR
func TeamSizeR(){
	x := TeamSize()
	fmt.Println(x)
	return
//export main
}
func main(){
	f, err := os.Create("saved_data/Settings.txt")

	if err != nil{
		log.Fatal(err)
	}

	defer f.Close()
	//x := Goalies()
	_, err2 := f.WriteString(Goalies()+"\n")
	_, err3 := f.WriteString(Defence()+"\n")
	_, err4 := f.WriteString(Offence()+"\n")
	_, err5 := f.WriteString(TeamSize()+"\n")

	if err2 != nil{
		log.Fatal(err2)
	}
	if err3 != nil{
		log.Fatal(err3)
	}
	if err4 != nil{
		log.Fatal(err4)
	}
	if err5 != nil{
		log.Fatal(err5)
	}
}