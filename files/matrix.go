package main

import (
	"bytes"
	"flag"
	//"fmt"
	"log"
	"math/rand"
	"os"
	"strconv"
)

var outerDim, innerDim, limit *int


func generate(randMatrix [][]int) {
    for i, innerArray := range randMatrix {
        for j := range innerArray {
            randMatrix[i][j] = rand.Intn(*limit)
        }
    }
}

func printMatrix(randMatrix [][]int) {
    f, err := os.Create("saved_data/Ai_Layers-Raw.txt")
	if err != nil{
		log.Fatal(err)
	}
	defer f.Close()
    for _, val := range randMatrix {
        A := val
        _, err2 := f.WriteString(arrayToString(A, " ")+"\n")
        //fmt.Println(arrayToString(A, ", "))
        //fmt.Println(val)
        if err2 != nil{
            log.Fatal(err2)
        }
    }
}

func main() {
    outerDim = flag.Int("outerDim", 17, "Outer dimension of the matrix")
    innerDim = flag.Int("innerDim", 17, "inner dimenstion of the matrix")
    limit = flag.Int("limit", 256, "matrix values are limited specified value")
    flag.Parse()
    randMatrix := make([][]int, *outerDim)
    for i := 0; i < *outerDim; i++ {
        randMatrix[i] = make([]int, *innerDim)
    }
    generate(randMatrix)
    printMatrix(randMatrix)
    
    
}

func arrayToString(A []int, delim string) string {

    var buffer bytes.Buffer
    for i := 0; i < len(A); i++ {
        buffer.WriteString(strconv.Itoa(A[i]))
        if i != len(A)-1 {
            buffer.WriteString(delim)
        }
    }

    return buffer.String()
}