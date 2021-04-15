/*
This trains the AI so it may take a 
while to draft depending on your computer
*/

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
	cmd := exec.Command("go", "run", "autodrafter/training/trainer.go")
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

	cmd1 := exec.Command("python", "autodrafter/compressor.py", "--input-file")
    stdout1, err1:= cmd1.StdoutPipe()
    if err1 != nil {
        panic(err1)
    }
    stderr1, err1 := cmd1.StderrPipe()
    if err1 != nil {
        panic(err1)
    }
    err1 = cmd1.Start()
    if err1 != nil {
        log.Fatal(err1)
    }

    go copyOutput(stdout1)
	go copyOutput(stderr1)
	
    cmd1.Wait()
	//ADD THE LABEL.PY FILE WORK AFTER
}