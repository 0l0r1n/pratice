# General Review

## Java

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



### Debugging

### Monitoring

### Performance

### Memory Management

### Concurrency
