package main

import (
	"bufio"
	"fmt"
	"io"
	"log"
	"os/exec"
)

func copyOutput(r io.Reader){
	scanner := bufio.NewScanner(r)
	for scanner.Scan(){
		fmt.Println(scanner.Text())
	}
}

func main(){
	cmd := exec.Command("ruby", "/Users/jakeleroux/Desktop/Fantasy Hockey/mathematics/playerattr.rb", "--inputfile")
	stdout, err := cmd.StdoutPipe()
	if err != nil{
		log.Fatal(err)
	}
	stderr, err := cmd.StderrPipe()
	if err != nil{
		log.Fatal(err)
	}
	err = cmd.Start()
	if err != nil{
		log.Fatal(err)
	}
	go copyOutput(stdout)
	go copyOutput(stderr)
	cmd.Wait()
}