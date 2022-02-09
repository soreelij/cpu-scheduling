# CPU Scheduling Simulation using a Priority Queue

* Author: Elijah Sorensen

## Overview

Priority queue max heap for simulation of round-robin CPU Process scheduling. Randomly generates processes adding them to the queue, following the scheduling algorithm, and outputting simulation results.

## Compiling and Using

From the directory containing all source files, compile the driver
class (and all dependent classes) with the command:
````````
$ javac CPUScheduling.java
````````
Run the compiled CacheTest class with the command and required command-line
arguments.

````````
$ java <max-process-time>  <max-priority>  <time-to-increment-priority> <simulation-time> <process arrival probability: (0..1)>
````````

The console will print a time unit by time unit simulation of the round-robin scheduling
algorithm utilizing the given input arguments, as well as a final, average completion time 
for each process.

## Results

````````
Running   java CPUScheduling 2 2 1 20 0.5 1234
 ---- Test 1 output matches!
Running   java CPUScheduling 1 1 2 10 0.5 1234
 ---- Test 2 output matches!
Running   java CPUScheduling 10 10 10 200 0.5 1234
 ---- Test 3 output matches!
Running   java CPUScheduling 10 10 10 100 0.9 1234
 ---- Test 4 output matches!
Running   java CPUScheduling 10 10 10 100 0.1 1234
 ---- Test 5 output matches!
````````
