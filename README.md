# Design Pattern
https://refactoring.guru/design-patterns 
## What is a Design Pattern?
● Standard solution to recurring problem \
● Codification of best practices \
● Has a name, problem, environment, solution, variations, sample code \
● Originally 23 patterns, now many more. Useful to look at because they \
illustrate some of the power of OOP (and also some of the pitfalls)

## How do Design Patterns help developers?
● Pattern gives name/vocabulary for communication of intent  
    ○ No need to explain details in e.g., code reviews \
● Provides as a “template” a worked-out “best practices” solution for you  
    ○ Has been reviewed by many senior developers \
● With practice you will recognize the patterns in existing code \
● And hopefully remember to use them in new code 👍

## Patterns we will cover
1. Singleton
2. Adapter
3. Decorator  
4. Observer 
5. Composite 
6. State
7. Strategy   
8. Factory
9. Optional 
 
## 1. Singleton 
Only one instance of an object is created by developers using our code \
    Ex. a class that encapsulates accessing a database over a network with only one connection at a time. \
Provide a global access point to that instance. \
Include solution to multi-threaded problems.

## 2. Adapter 
Introduce a bridge between two incompatible interfaces.

**Target**: The Interface / class that the rest of your code is going to use. \
**Adaptee**: The class that we’re trying to adapt. \
Often 3rd-party, legacy or with lots of existing dependencies.\
**Adapter**: The class that will adapt method calls from the target to the Adaptee. 

## 3. Decorator 
The most common relationships between classes are \
• Dependence (“uses–a”) \
• Inheritance (“is–a”) \
Object itself does the work.\
• Aggregation (“has–a”) \
Object delegates the work through reference to others and alter the result.

Problems with Inheritance \
● Static, Single Relationship \
○ Defined at Compile-time, can’t customise at runtime \
● Inheritance based Coupling \
● Misuse of Inheritance, Inheritance implies: Latte is an Espresso - not true 

Aggregation
Add state or methods at runtime\
Enables more flexible addition of behaviour, not hard-bounding \
Combining multiple behaviours

**Component**: The Component defines the interface for objects that can have responsibilties added dynamically \
**ConcreteComponent**: It is simply an implementation of Component interface \
**Decorator**: The Decorator has a reference to a Component, and also conforms to the Component interface. Decorator is essentially wrapping the Component \
**ConcreteDecorator**: The ConcreteDecorator just adds responsibilities to the original Component. 

## 4. Observer
 Define a 1:M dependency between objects so that when one object changes state, all its dependents are notified automatically \
● Enables decoupling between publisher and subscriber \
● Enables dynamic attachment/removal of subscribers 

## 5. Composite
How can we treat a group of objects as a single object? \
Composite is a structural design pattern that lets you compose objects into tree structures and
then work with these structures as if they were individual objects.

The **Component** interface describes operations that are common to both simple and complex elements of the tree. \
The **Leaf** is a basic element of a tree that doesn’t have sub-elements. \
Usually, leaf components end up doing most of the real work, since they don’t have anyone to
delegate the work to. \
The **Container (aka composite)** is an element that has sub-elements: leaves or other containers. \
A container doesn’t know the concrete classes of its children. 
It delegates all the work to sub-elements only via the component interface.


## 6. State
## 7. Strategy   


## 8. Factory
## 9. Optional 