# Creational Design Patterns 
Provide object creation mechanisms that increase flexibility and reuse of existing code.
<br>Eg: Factory, Abstract Factory, Builder, Prototype, Singleton

## Factory (Virtual Constructor)
Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

When we want to create a object on the basis of some condition
```
// Creator class, Factory class to to create a shape object
public class ShapeFactory {

    // Use getShape method to get object of type Shape
    // Factory method
    public Shape getShape(String shapeType) {
        if(shapeType == null) {
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        // Get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}

```

## Abstract Factory (Factory of Factory)
Pattern that lets you produce families of related objects without specifying their concrete classes. when it is possible to group the products that factory could return, then each group could be considered as a product that will be returned by another factory

## Builder
When in a class there are lots of fields and most of them are optional. Require object will be created step by step, say we want create a House object then we can build this in phases as
- add_roof()
- add_wall()
- add_door()
- add_windows()
- build() 

here build method will return object of House

Builder class are either interface or abstract

## Object Pool
- Manages the poll of reusable objects like DB connection object, borrow from the pool -> use it -> then return it back to the pool
- Resource manager maintains list of available object and in-use objects
- Singleton and thread safety required

## Prototype Pattern
When we have to make a copy/clone from existing object or when we want a object which has small difference than current one. Cloning a object should be responsibility of class not client, class may expose a method called clone, it's better that there exists Prototype interface with method clone that all class has to implement.

## Singleton Pattern
When only one instance is allowed

```java
public class DBConnection{
    private static DBConnection conObject;
    private DBConnection(){}
    
    public static DBConnection getInstance(){
        if(conObject == null){
            synchronized (DBConnection.class){
                if(conObject == null){
                    conObject = new DBConnection();
                }
            }
        }
        return conObject;
    }
}

```