package main

import (
    "bufio"
    "fmt"
    "io"
    "os/exec"
	"log"
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
        log.Fatal(err)
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

	cmd3 := exec.Command("go","run", "files/matrix.go")
	stdout3, errq := cmd3.StdoutPipe()
	if errq != nil{
		panic(errq)
	}
	stderr3, errq := cmd3.StderrPipe()
	if errq != nil{
		panic(errq)
	}
	errq = cmd3.Start()
	if errq != nil{
		panic(errq)
	}

	go copyOutput(stdout3)
	go copyOutput(stderr3)

	cmd3.Wait()

	cmd4 := exec.Command("go","run", "files/matrixval.go")
	stdout4, erre := cmd4.StdoutPipe()
	if erre != nil{
		panic(erre)
	}
	stderr4, erre := cmd4.StderrPipe()
	if erre != nil{
		panic(erre)
	}
	erre = cmd4.Start()
	if erre != nil{
		panic(erre)
	}

	go copyOutput(stdout4)
	go copyOutput(stderr4)

	cmd4.Wait()

	cmd5 := exec.Command("python", "files/weights.py", "--input-file")
	stdout5, errw := cmd5.StdoutPipe()
	if errw != nil{
		panic(errw)
	}
	stderr5, errw := cmd5.StderrPipe()
	if errw != nil{
		panic(errw)
	}
	errw = cmd5.Start()
	if errw != nil{
		panic(errw)
	}

	go copyOutput(stdout5)
	go copyOutput(stderr5)

	cmd5.Wait()

	cmd6 := exec.Command("go","run", "autodrafter/draft.go")
	stdout6, err6 := cmd6.StdoutPipe()
	if err6 != nil{
		panic(err6)
	}
	stderr6, err6 := cmd6.StderrPipe()
	if err6 != nil{
		panic(err6)
	}
	err6 = cmd6.Start()
	if err6 != nil{
		panic(err6)
	}

	go copyOutput(stdout6)
	go copyOutput(stderr6)

	cmd6.Wait()

	/* JAVA FILES */
	cmd7 := exec.Command("javac","app/java.main")
	stdout7, err7 := cmd7.StdoutPipe()
	if err7 != nil{
		panic(err7)
	}
	stderr7, err7 := cmd7.StderrPipe()
	if err7 != nil{
		panic(err7)
	}
	err7 = cmd7.Start()
	if err7 != nil{
		panic(err7)
	}

	go copyOutput(stdout7)
	go copyOutput(stderr7)

	cmd7.Wait()

	cmd8 := exec.Command("java","app/main.java")
	stdout8, err8 := cmd8.StdoutPipe()
	if err8 != nil{
		panic(err8)
	}
	stderr8, err8 := cmd8.StderrPipe()
	if err8 != nil{
		panic(err8)
	}
	err8 = cmd8.Start()
	if err8 != nil{
		panic(err8)
	}

	go copyOutput(stdout8)
	go copyOutput(stderr8)

	cmd8.Wait()

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