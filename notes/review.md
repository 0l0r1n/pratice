# General Review

## Java

### Best practices

1. Return empty collections/optionals instead of null
2. Use string builder
3. Use finally
4. Use static factory methods: named, do not necessarily require a new object; can return a subtype of the requested object.
5. use a builder to facilitate construction when there is a lot of params
6. DI over hardwiring
7. Avoid creating unnecessary objects. Reuse objects when it makes sense to do so
8. Eliminate object references that are nto being used - careful with caches, listeners and other callbacks
9. Obey general rules when overriding equals/hashcode. Always override hashcode when overriding equals
10. Always override toString
11. Minimise accessibility of classes and members
12. Use accessors
13. Minimise mutability - no state changes, fields are final, class cannot be extended, fields are private. Classes should be mutable unless there is a good reason to make them immutable
14. Favour composition over inheritance
15. Prefer interfaces to abstract classes - java only allows one extension but multiple implementations
16. Use bounded wild cards to increase API flexibility
17. Make defensive copies when needed
18. Avoid float and double. Use BigDecimal
19. Use checked exceptions for recoverable conditions and runtime exceptions for programming errors

### Garbage Collection

- Process by which Java performs automatic memory management
- Projects are created on the heap and eventually will not be needed anymore
- Unused objects are collected and freed up

#### Basic process

1. Unreferenced objects identified and marked for collection
2. Marked objects are deleted. Optionall memory can be compacted after the garbage collector deletes objects so remaining objects are in a continguous block at the start of the heap.

Hotspot's garbage collectors implement a generational garbage collection strategy that categorises obejcts by age. Most objects are short-lived. The heap is divdided into three sections:

- Young generation: divided into Eden and Survivor.
- Old generation
- Permanent generation (does not apply to Java 8)

During a full garbage collection event, unusued objects in all generations are garbage collected. Four garbage collectors:

- Serial: all garbage collections are conducted serially in one thread. Compaction is executed after each garbage collection.
- Parallel: multiple threads are used for minor gargabe collection. A single thread is used from major garbage collection and old generation compaction.
- CMS (Concurrent Mark Sweep): multiple threads are used for minor gargabe collection using the same algorithm as Parallel.
- G1 (Garbage First): newest garbage collector is intendend as a replacement for CMS

##### Benefits of Java GC

- Autopmatic handling deletion unused objects that are out of reach.

##### Java Collection Best Practices

- Generally does not need to be considered
- Non deterministic. System.gc() and Runtime.gc() can be used but they do not provide guarantees that GC will run.
- Best approach is to set flags on the JVM as well as size of the heap, size of heap sections
- Parallel GC is efficient but will frequently cause stop the world events; suited for backend processing where long pauses for garbage collection are acceptable
- CMS GC is designed to minimise pauses, making it ideal for GUI apps
- Can use jstat to measure
- Can create log statements

### Collections

Framework that provides an architecture to store and manipulate groups of objects. Can achieve all operations that you perform on a data such as searching, inserting, sorting, manipulating and deleting.

It has:

1. Interfaces and implementations
2. Algorithms

#### Interfaces/Classes

- Iterator
- Iterable
- Collection
- List

- ArrayList: dynamic array
- LinkedList: doubly linked list
- Vector: synchronized dynamic arary
- Stack: LIFO
- Queue: FIFO
- PriorityQueue: stored by priorities
- Deque: can add and remove from both sides
- ArrayDeque: implementation of Deque
- Set: unordered elements
- HashSet: implementation of Set that uses a hash table for storage
- LinkedHashSet: extension of HashSet; maintains orders
- SortedSet: implementation of set and provides total ordering
- TreeSet: set that uses tree for storage
- Map: key value/pairs
- HashMap: implementation of map; unordered
- LinkedHashMap: maintains insertion order
- TreeMap: maintains insertion order (RBT)
- HashMap is not synchronised or thread-safe; can't be shared between many threads without proper sync code
- HashMap allows one null key

#### Java 8

##### Streams

- Used to process collection of objects; a stream is a sequence of objects that support various methods which can be pipelined.
- Do not change original data
- Lazily executed
- Support functional programming style
- Can be parallel
- Operations can be intermediate or terminal

###### Intermediate

1. map
2. filter
3. sorted
4. flatMap

###### Terminal

1. Collect
2. forEach
3. reduce

Operations will only process if there is a terminal operation present. As soon as you call any terminal operation, the stream is closed.

### Testing

#### JUnit

- Defined with @Test
- Use @Before for setup
- Use assert to check results
- Can setup test suite

#### Mockito

- Used with JUnit to mock objects, external dependencies and predict behaviour
- Always @RunWith(Mockito.JUnitRunner.class) to init mocks
- when/then
- @InjectMocks for DI
- Use argument captors to make sure a specific argument was passed to another class

### Generics

- ? wildcard: unbounded
- ? extends T: upper bound
- ? super T: lower bound

### Debugging

- Set breakpoints
- Click on bug icon
- Rejoyce

### Monitoring

There are two types of metrics to be concerned with: JVM and underlying infrastructure.

- Use a JVM profiler to monitor cpu/memory usage/GC activity
- Java Web Requests and Transactions
- RUM (Real User Monitoring)
- Server logs

#### JVM Monitoring

- Heap usage
- GC
- Active threads
- Response time

#### Infrastructure Monitoring

- CPU Utilization
- Memory usage/RAM
- Available Threads
- Open File Descriptors
- Database Connections
- SLA
- Latency
- Success of API Endpoints
- Average Response Times
- Errors and Exceptions
- Health and Status of Dependencies

### Performance

Can be defined in multiple ways but basics are:

- the ability of a program to perform its computing tasks within the business response time requirements
- Ability of application to fulfill its business functions under high volume with high reliability and low latency
- JVM pauses for GC on young generation

Tips:

- Don't do pre-mature optimization
- Work on biggest bottlenecks first
- Use a profiler

#### Areas of concern

- Performance degradation JVM restart: avoid deploying excessive amount of java classes to a singel application classloader.
- Excessive class loading contention observed at runtime (thread locks, JAR file searches): profile app and identify code modules performing dynamic class loading operations too frequently; be careful with reflection

### Memory Management

Memory leaks often involve small amounts of memory resources. Reported with a java.lang.OutOfMemoryError.

- Always release db connections
- Try to use finally block

### Concurrency

- It is defined as ability to execute several tasks in parallel.
- synchronized keyword: only one thread at a time allowed to access parts of the code. Immutable data structures to the rescue!
- You can't avoid concurrency
- synchronized is not just about mutex
- synchronization guarantees that no method will observe the object in an inconsistent state
- volatile keyword - never cache, always read it from main memory
- confine mutable data to a single thread
- A thread is an independent path of execution
- Process has many threads with shared memory space
- Vector is thread-safe and array list is not
- There is no guarantee a thread will stop calling stop. Better use volatile variables instead

#### Levels of thread safety

- Immutable
- Unconditionally thread-safe
- Conditionally thread-safe
- Not thread-safe
- Thread-hostile

#### Thread lock contention

By fast the most common concurrency problem. When 1 to n thread (s) is waiting to acquire a lock on a particular object.

#### Multithreading

Threads are lightweight processes within a process. Can be used by:

1. Extending the thread class
2. Implementing the runnable interface

#### Monitors

#### Deadlocks

- Triggered when two or more threads are blocked forever, waiting for each other.

#### Clock Time and CPU Burn

It is important to know highest clock time and CPU burn contributors. High CPU consumption is often a symptom of inefficient implementation.

## System design

### Scalability

### Security

- web, CSRF

### Microservices

### Connection pool

### Rest API
