# Creational Design Patterns

## Introduction to creational design patterns
Creational design patterns deal with object creation mechanisms. As the name implies, these patterns provide optimized object creation techniques.

## Factory Pattern
It is used in complex situations where the type of the object required varies and needs to be specified in each case. It does not use the new keyword directly to instantiate objects. This means that it does not explicitly require the use of a constructor to create objects. Instead, it provides a generic interface that delegates the object creation responsibility to the corresponding subclass.

- When the type of objects required cannot be anticipated beforehand.
- When multiple objects that share similar characteristics need to be created.
- When you want to generalize the object instantiation process, since the object set up is complex in nature.

## Constructor pattern
It is a class-based pattern that uses the constructors present in the class to create specific types of objects.

- You can use it when you want to create multiple instances of the same template, since the instances can share methods but can still be different. 
- It can be useful in the Libraries and Plugins design.

## Singleton pattern
Restricts the instantiation of a class to a single object. This allows the class to create its instance the first time it is instantiated.However, on the next try, the existing instance of the class is returned. No new instance is created.

- The Singleton pattern is mostly used in cases where we want a single object to coordinate actions across a system.
- Services can be singleton since they store the state, configuration, and provide access to resources. Therefore, it makes sense to have a single instance of a service in an application.
- Databases such as MongoDB utilize the Singleton pattern when it comes to database connections.
- Configurations are used if there is an object with a specific configuration, and we don’t need a new instance every time that configuration object is needed.

## Builder pattern
When building complex objects using simpler objects, step-by-step approach towards making these objects.

- You can use this design pattern when building apps that require you to create complex objects. It can help you hide the construction process of building these objects.

## Prototype pattern
Instantiate objects with some default values using an existing object. It clones the object and provides the existing properties to the cloned object using prototypal inheritance.

- To eliminate the overhead of initializing an object.
- When we want the system to be independent about how the products in it are created.
- When creating objects from a database whose values are copied to the cloned object.

## Abstract pattern
Similar to Factory pattern, the difference is that it provides a constructor to create families of related objects. It is abstract, which means that it does not specify concrete classes or constructors.

- Applications requiring the reuse or sharing of objects.
- Applications with complex logic because they have multiple families of related objects that need to be used together.
- When we require object caching.
- When the object creation process is to be shielded from the client.