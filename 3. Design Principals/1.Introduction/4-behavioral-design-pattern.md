# Behavioral Design Patterns


## Introduction
Ensure effective communication between different objects in a system, assign responsibilities to them, and make sure they all have synchronized information.

## Chain of Responsibility pattern
Allows a request sent by a client to be received by more than one object. It creates a chain of loosely-coupled objects that, upon receiving the request, either handle it or pass it to the next handler object.

- It can be used where a program is written to handle various requests in different ways without knowing the sequence and type of requests beforehand. 

## Command pattern
Allows encapsulation of the requests or operations into separate objects. It decouples the objects that send requests from the objects responsible for executing those requests.

## Iterator pattern
Allows the definition of various types of iterators that can be used to sequentially iterate a collection of objects without exposing the underlying form.

## Mediator pattern
It is a behavioral pattern that allows a mediator (a central authority) to act as the coordinator between different objects instead of the objects referring to each other directly. A mediator, as the name implies, is a central authority through which various components can communicate. It allows the loose coupling of objects.

## Observer pattern
It allows objects (observers) that have subscribed to an event to wait for input and react to it when notified. Therefore, they don’t have to continuously keep checking whether the input has been provided or not. 

## Visitor pattern
Lets you separate algorithms from the objects on which they operate.

