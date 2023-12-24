package main

import (
	"context"
	"encoding/json"
	"errors"
	"fmt"
	"net/http"
	"sync"
	"time"
)

type Processor func(context.Context) (string, error)

func doWork(workType string, durationSecond int, result chan<- string) {
	fmt.Println("Work with - " + workType)
	time.Sleep(time.Duration(durationSecond) * time.Second)
	if workType == "RemoteServer" {
		response, err := http.Get("http://localhost:3000/users")
		if err != nil {
			result <- err.Error()
		}
		defer response.Body.Close()
		var data UsersResponse
		if err := json.NewDecoder(response.Body).Decode(&data); err != nil {
			result <- err.Error()
		}
		result <- fmt.Sprintf("Result from %s %s", workType, fmt.Sprint(data))
	} else {
		result <- fmt.Sprintf("Result from %s", workType)
	}
}

func goToRemoteServer(ctx context.Context) (result string, err error) {
	fmt.Println("RemoteServer is working...")

	resultChannel := make(chan string)
	go doWork("RemoteServer", 2, resultChannel)

	for {
		select {
		case <-ctx.Done():
			if errors.Is(ctx.Err(), context.DeadlineExceeded) {
				fmt.Println("RemoteServer cancelled")
				return "", nil
			}
		case result = <-resultChannel:
			fmt.Println("RemoteServer done")
			return result, nil
		}
	}

}

func goToDataBase(ctx context.Context) (result string, err error) {
	fmt.Println("DataBase is working...")

	resultChannel := make(chan string)

	go doWork("DataBase", 4, resultChannel)

	for {
		select {
		case <-ctx.Done():
			if errors.Is(ctx.Err(), context.DeadlineExceeded) {
				fmt.Println("DataBase cancelled")
				return "", nil
			}
		case result = <-resultChannel:
			fmt.Println("DataBase done")
			return result, nil
		}
	}
}

func goToDisk(ctx context.Context) (result string, err error) {
	fmt.Println("Disk is working...")

	resultChannel := make(chan string)

	go doWork("Disk", 8, resultChannel)

	for {
		select {
		case <-ctx.Done():
			if errors.Is(ctx.Err(), context.DeadlineExceeded) {
				fmt.Println("Disk cancelled")
				return "", nil
			}
		case result = <-resultChannel:
			fmt.Println("Disk done")
			return result, nil
		}
	}
}

func processRequest(ctx context.Context, processors []Processor) {
	ctx, cancel := context.WithTimeout(ctx, time.Second*4)
	defer cancel()
	var wg sync.WaitGroup
	for _, processor := range processors {
		wg.Add(1)
		go func(p Processor, wg *sync.WaitGroup) {
			result, err := p(ctx)
			if err != nil {
				fmt.Println("Error - " + err.Error())
			} else if result != "" {
				fmt.Println("-> " + result)
			}
			wg.Done()
		}(processor, &wg)
	}
	wg.Wait()
}

func main() {
	ctx := context.Background()

	processors := []Processor{goToRemoteServer, goToDataBase, goToDisk}

	processRequest(ctx, processors)
}
