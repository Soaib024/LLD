## Decorator Pattern
### 1. What is the Decorator Pattern?
- The Decorator pattern adds new behavior to an object dynamically at runtime, without modifying the original class.
- It is used to extend functionality without inheritance.

### 2. Why use it?
- To add features dynamically
- To avoid inheritance explosion
(e.g., CoffeeWithMilk, CoffeeWithSugar, CoffeeWithMilkAndSugar…)
- To follow Open-Closed Principle
(open for extension, closed for modification)
- To compose multiple behaviors flexibly

### 3. Real-Life Analogy
- Think of a pizza:
- Base: pizza bread
- Add-ons: cheese, olives, mushroom, paneer, etc.

You don’t create 100 separate classes of pizza.

## Components of the Pattern
### 1. Component (Interface/Abstract Class):
- Defines the interface for objects that can have responsibilities added to them. Both the concrete components and the decorators must implement this interface.
- Example: `coffeeShop.Coffee` interface with a `getDescription()` and a `getCost()` method.

### 2. Concrete Component
- The base object to which responsibilities can be added. This is the object being "decorated."
- Example: A `coffeeShop.SimpleCoffee` class.

### 3. Decorator (Abstract class)
- Maintains a reference (or pointer) to a Component object. It must conform to the Component interface.
- This abstract class serves as the base for all specific decorators.

### 4. Concrete Decorator:
- Adds responsibilities to the component.
- It implements the operations of the Component interface and can optionally wrap or enhance the operation of the component it holds a reference to.
- Examples: coffeeShop.MilkDecorator, coffeeShop.SugarDecorator, SyrupDecorator.