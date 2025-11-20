## Core Concept: Part-Whole Hierarchy
The Composite pattern organizes objects into tree-like structures to represent part-whole hierarchies. 
It enables clients to work with a single object (a leaf) or a collection of objects (a composite) using the same interface.

## Components of the Pattern
The pattern involves three main types of participants:

### 1. Component (Interface/Abstract Class):
- Defines the interface for all objects in the composition (both leaf nodes and composite nodes).
- It includes methods for behavior (the common operation) and optionally, methods for managing children (e.g., `add()`, `remove()`).

### 2. Leaf:
- Represents the individual objects in the composition. These are the basic building blocks that have no children.
- They implement the behavior defined by the Component interface.

### 3. Composite:
- Represents the group of objects (the branches of the tree).
- It stores a collection of child components (both Leaves and other Composites).
- It implements the Component interface, and its operations typically delegate to its children, often performing the operation on all children recursively.