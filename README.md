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
1. Singleton    (Creational)
2. Factory      (Creational) 
   
3. Adapter      (Structural) 
4. Decorator    (Structural) 
   
5. Observer     (Behavioural)
6. Composite    (Structural) 
   
7. State        (Behavioural)
8. Strategy     (Behavioural) 

9.  Optional    (Exception)
 
## Compare and Contrast
1, 2 are all Creational patterns.
1. Singleton stores a private static final instance and lazy instantiates it.
    Composition of singleton
2. Factory Design is using class method to replace new, Factory has a method createInstance for different subtypes.
    Composition of the main class (usually with derived class)

3, 4 , 6 are all wrappers. (Structural) 
They are all achieved by using composition (in adapter, decorator and composite).
1. Adapter wraps A to B ( different inheritance tree ). 
   Composition of service.
2. Decorator wraps A to A*. 
   Composition of component interface.
3. Composite wraps A to A[].
   Composition of component interface. 

5, 7, 8 are all Behavioural patterns. (State, Method and Communication)
They are all achieved by using composition (in the context at least).
5. Observer identifies common communication patterns between objects.
[A publisher vs a list of observers 1:M, Composition]
7. State changes its state (composition) at runtime
8. Strategy selects Algorithms (composition) on the fly.

Design Pattern Meaning:
Open for extension, Closed for modification.
There is no need to achieve the above ... functionality by changing existing code.

## 1. Singleton 
[Code Here](./Singleton_single_threaded.java) \
Only one instance of an object is created by developers using our code \
    Ex. a class that encapsulates accessing a database over a network with only one connection at a time. \
Provide a global access point to that instance. \
Include solution to multi-threaded problems.

## 2. Factory
[Code Here](./Factory.java) \
new “considered harmful” 

So Factory Design is using class method to replace new, Factory has a method createInstance for different subtypes.

Factory Method is a creational design pattern that provides an interface for creating objects in a
superclass, but allows subclasses to alter the type of objects that will be created.

Avoid tight coupling between the creator and the concrete products.

The **Product** declares the interface, which is common to all objects that can be produced by the creator and its subclasses.\
**Concrete Products** are different implementations of the product interface.\
The **Creator** class declares the factory method that returns new product objects. It’s
important that the return type of this method matches the product interface. Dependence (“uses–a” product) \
**Concrete Creators** override the base factory method so it returns a different type of product. \
Note that the factory method doesn’t have to create new instances all the time. It can also return existing objects from a cache, an object pool, or another source.

## 3. Adapter 
[Code Here](./Adapter.java) \
Introduce a bridge between two incompatible interfaces.

**Target**: The Interface / class that the rest of your code is going to use. \
**Adaptee**: The class that we’re trying to adapt. \
Often 3rd-party, legacy or with lots of existing dependencies.\
**Adapter**: The class that will adapt method calls from the target to the Adaptee. 

## 4. Decorator 
[Code Here](./Decorator.java) \
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

Problems: will be verbose and difficult due to the wrapper.
Need to aggregate another object, adding up to the complexity.

**Component**: The Component defines the interface for objects that can have responsibilties added dynamically \
**ConcreteComponent**: It is simply an implementation of Component interface \
**Decorator**: The Decorator has a reference to a Component, and also conforms to the Component interface. Decorator is essentially wrapping the Component \
**ConcreteDecorator**: The ConcreteDecorator just adds responsibilities to the original Component. 

## 5. Observer
[Code Here](./Observer.java) \
 Define a 1:M dependency between objects so that when one object changes state, all its dependents are notified automatically \
● Enables decoupling between publisher and subscriber \
● Enables dynamic attachment/removal of subscribers 

## 6. Composite
[Code Here](./Composite.java) \
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


## 7. State
[Code Here](./State.java) \
 Let an object alter its behaviour when its internal state changes. \
 It appears as if the object changed its class. (finite number of states)

## 8. Strategy   
[Code Here](./Strategy.java) \
Lets you define a family of algorithms, put each of
them into a separate class, and make their objects interchangeable.


## 9. Optional 
[Code Here](./OptionalDemo.java) 