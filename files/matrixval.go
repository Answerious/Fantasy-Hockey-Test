/*
package main

import (
    "fmt"
    "io/ioutil"
    "log"
)

func main() {

    content, err := ioutil.ReadFile("saved_data/Ai_Layers-Raw.txt")

     if err != nil {
          log.Fatal(err)
     }

    fmt.Println(string(content))
}
*/
package main

import (
	"bufio"
	//"flag"
	"strings"
	//"fmt"
	"log"
	"os"
)
 
func main() {
	//var total [17]string
	var dat []string
	file, err := os.Open("saved_data/Ai_Layers-Raw.txt")
 
	if err != nil {
		log.Fatalf("failed opening file: %s", err)
	}
 
	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanLines)
	var txtlines []string
 
	for scanner.Scan() {
		txtlines = append(txtlines, scanner.Text())
	}
 
	file.Close()
	f, errt := os.Create("saved_data/Ai_Layers-Combined.txt")
	if errt != nil{
		log.Fatal(errt)
	}
	defer f.Close()

	datawriter := bufio.NewWriter(f)

	for _, eachline := range txtlines {
		data := append(dat, eachline)
		//fmt.Println(data)
		_, err := datawriter.WriteString(strings.Join(data, `(?s)\((.*)\)`))
		if err != nil {
			log.Fatalf("failed writing to file: %s", err)
			return
		}
	
		err = datawriter.Flush()
		if err != nil {
			log.Fatalf("failed to flush the writer: %s", err)
			return
		}
	
	}
	datawriter.Flush()
}