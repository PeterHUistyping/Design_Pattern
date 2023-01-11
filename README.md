# Design Pattern

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
1. Strategy 
2. Adapter 
3. Decorator 
4. Optional 
5. Singleton 
6. Factory 
7. Observer

## 3. Decorator 
Component: The Component defines the interface for objects that can have responsibilties added dynamically \
ConcreteComponent: It is simply an implementation of Component interface \
Decorator: The Decorator has a reference to a Component, and also conforms to the Component interface. Decorator is essentially wrapping the Component \
ConcreteDecorator: The ConcreteDecorator just adds responsibilities to the original Component. 

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

## 5. Singleton 
 
Include solution to multi-threaded problems.