package main

import (
    "bufio"
    "fmt"
    "io"
    "os/exec"
)

func main() {
    cmd := exec.Command("python", "files/saving_data.py", "--input-file")
    stdout, err := cmd.StdoutPipe()
    if err != nil {
        panic(err)
    }
    stderr, err := cmd.StderrPipe()
    if err != nil {
        panic(err)
    }
    err = cmd.Start()
    if err != nil {
        panic(err)
    }

    go copyOutput(stdout)
	go copyOutput(stderr)
	
    cmd.Wait()

	cmd2 := exec.Command("go","run","files/data.go")
	stdout2, errt := cmd2.StdoutPipe()
	if errt != nil{
		panic(errt)
	}
	stderr2, errt := cmd2.StderrPipe()
	if errt != nil{
		panic(errt)
	}
	errt = cmd2.Start()
	if errt != nil{
		panic(errt)
	}

	go copyOutput(stdout2)
	go copyOutput(stderr2)

	cmd2.Wait()
	/*

	cmd1 := exec.Command("go run", "data.go")
    stdout1, errt := cmd1.StdoutPipe()
    if errt != nil {
        panic(errt)
	}
	stderr1, errt := cmd1.StderrPipe()
	if errt != nil {
		panic(errt)
	}
	errt = cmd1.Start()
	if errt != nil {
		panic(errt)
	}

	go copyOutput(stdout1)
	go copyOutput(stderr1)

	cmd1.Wait()
	*/
}

func copyOutput(r io.Reader) {
    scanner := bufio.NewScanner(r)
    for scanner.Scan() {
        fmt.Println(scanner.Text())
    }
}