# Project 2: CPU Scheduling Simulation using a Priority Queue

* Author: Elijah Sorensen
* Class: CS321 Section 003
* Semester: Fall 2021

## Overview

CPUScheduling runs a simulation of the round-robin scheduling algorithm for testing its
implementation of a PriorityQueue MaxHeap made up of randomly-generated Process objects.

## Reflection

This project challenged me much more than I anticipated. Implementing a MaxHeap ADT was straightforward
enough, provided the pseudocode from our textbook. However, where I started to run into serious
snags after my testing phase was the design decision I made to attempt to create a MaxHeap with
the ability to store Generic objects (as we'd touched on in CS321). Amit mentioned in class that 
to successfully do so would result in extra credit, so feeling confident and wanting a challenge,
I attempted to do so.

The issue arose when I attempted to typecast the MyPriorityQueue class (which extended my GenericMaxHeap)
class to store Process objects, and because the compareTo method in my Process class wasn't a true
Comparable object, the compiler wouldn't allow me to run CPUScheduling and test my implementation.
The result was having a lot less time to test MyPriorityQueue than I liked, and I ended up having 
to rewrite a MaxHeap class using a modified version of the GenericMaxHeap I originally created and tested.
My hastiness to implement the second half of the project resulted in a hefty debugging process
that I barely completed on time. Still, my project passes the tests on Onyx, and I am grateful
that I took note of the ADT challenge and attempted it. I learned a lot more from all of those
hiccups and failures than I would have if I'd tried for the easier, more straightforward path.

Included in my project are both the original, GenericMaxHeap class, along with my final, working
implementation.

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

Initially, I only consistently passed Test 2. Still, after I fixed a minor error in
my update() method inside MyPriorityQueue, Onyx reads the following output upon running
all 5 tests:
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
