## Core Concept: The Surrogate
The key idea is that the proxy object acts as an intermediary to the real object (the subject). 
The client interacts with the proxy, which then manages or controls the requests to the real object. 
The proxy and the real subject must share a common interface so that the client doesn't know (or doesn't need to know) 
whether it's dealing with the real object or the proxy.

## Components of the Pattern
The Proxy pattern typically involves three main parts:

### 1. Subject (Interface):
- Defines the common interface for both the RealSubject and the Proxy. This ensures that the proxy can be used wherever the real subject is expected.
- Example: Image interface with a display() method.

### 2. Real Subject:
- The actual object that the proxy represents. This is the object that performs the core, often resource-intensive task.
- Example: HighResolutionImage class that loads a large file from a disk.

### 3. Proxy:
- Maintains a reference to the RealSubject.
- Implements the Subject interface.
- Controls access to the RealSubject. It can create the RealSubject on demand (lazy loading), check permissions, or perform other tasks before delegating the request to the real subject.