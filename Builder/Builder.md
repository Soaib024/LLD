- The Builder Design Pattern is a creational pattern that lets you construct complex objects step-by-step, 
separating the construction logic from the final representation.
- An object requires many optional fields, and not all of them are needed every time.
- When building such objects, developers often rely on constructors with many parameters or expose setters for every field

### In the Builder Pattern:
- The construction logic is encapsulated in a Builder.
- The final object (the "Product") is created by calling a build() method.
- The object itself typically has a private or package-private constructor, forcing construction through the builder.

### 1. Builder (e.g., HttpRequestBuilder)
- Defines methods to configure or set up the product.
- Typically returns this from each method to support a fluent interface.
- Often implemented as a static nested class inside the product class.
### 2. ConcreteBuilder (e.g., StandardHttpRequestBuilder)
- Implements the Builder interface or defines the fluent methods directly.
- Maintains state for each part of the product being built.
- Implements the build() method that returns the final product instance.
### 3. Product (e.g., HttpRequest)
- The final object being constructed.
- May be immutable and built only via the Builder.
- Has a private constructor that takes in the builder’s internal state.
### 4. Director (Optional) (e.g., HttpRequestDirector)
- Orchestrates the building process using the builder.
- Useful when you want to encapsulate standard configurations or reusable construction sequences.
- In modern usage (especially in Java with fluent builders), the Director is often omitted, and the client takes on this role by chaining methods.