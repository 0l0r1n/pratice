# Misc subjects

## Signed integer vs Unsigned integer

A signed integer is an integer that could be both positive or negative. Unsigned integer can only be positive. A signed integer will have a 0 in the topmost bit for positive numbers and 1 for a negative number. Unsigned ints use the left most bit as part of the value. For an n-bit integer, the signed version can hold values from -2^(n-1) to 2^(n-1) - 1. The unsigned version can hold values from 0 to 2^n - 1.

## Quick select

Selection algorithm to find the kth smallest element in an unordered list. Runs on O(n) for average case and O(n^2) for worst.

## Median of medians

Approximate median selection algorithm. Used by quick select to search for a good pivot. Runs on O(n) for both best and worst cases.

## Databases

### Relational

Stands for structured query language. Used with RDBMS and RDSMS. Useful with structured data. Scope of SQL - data query, manipulation, definition and access control. Data is sctored across multiple tables and linked using relationships. Properties

- Schema on write
- Atomic values
- Each row is unique
- Sequence of columns is insignificant
- Each column is named
- Integrity constraints maintain data consistency across multiple tables

#### CAP Theorem

A distributed db system can only have 2 of the 3: high consistency, availability and partition tolerance.

##### Partition Tolerance

The system continues to run, despite the number of messages being delayed by the network between nodes. A system that is partition tolerant can sustain any amount of failure that doesn't result in a failure of the entire network.

###### High consistency

All nodes see the same data at the same time. system has consistency if a transaction starts with the system in a consistent state, and ends with the system in a consistent state.

###### High Availability

This condition states that every request gets a response on success/failure. Achieving availability in a distributed system requires that the system remains operational 100% of the time.

#### ACID

Set of properties about database transactions intendeed to guarantee validity even if there are errors.

##### Atomicity

Transactions are composed of multiple statements. Atomicity guarantees that each transaction is treated as single unit. If part of it fails, the whole transaction fails and the db is left unchanged.

##### Consistency

Transactions can be only bring the db to a new valid state. Transactions have to be legal.

##### Isolation

Even if things happened concurrently, dbs ensures that execution happens as if it was sequentially.

##### Duratibility

Once a transaction has been commited, it will remain committed even in the case of a system failure.

### NoSQL

A schema on read type of database that enables extra flexibility without having to define a schema. Specially useful for big data. Reasons to choose NoSQL

- Store large volumes of data that might have little to no structure
- Make the most of cloud computing and storage
- To speed development
- To boost horizontal scalability

Attributes:

- Higher scalability
- Distributed computing
- Cost effective
- Flexible schema/schema on ead
- Able to process structured and semi-structured data
- No relationships

Types:

- Key value
- Column
- Document
- Graph

#### BASE

- Basically available
- Soft state
- Eventual consistency

### NewSQL

New class of modern relational db systems that scale and perform like NoSQL for OLTP while maintaining ACID guarnatees.

## Registries, Caches, RAM and HDs

Hardware or software component that stores data so that future requests can be served faster. A cache hit occurs when requested data can be found in a cache while a cache miss occurs when it cannot.

Registers are small memories withing the CPU, the nearest ones. These are accumulator, data register, progrm counter, general counter. Used for different tasks. Registers are crucial for cpu.

Cache resides within the processor chip. Very fast and nearer to cpu than ram. Main aim is to fill it with data which might be needed again soon. There are generally three levels, L1, L2 and L3. L3 is the largest and slowest.

Different types of electrical circuits are used so they operate at different speeds.

Computer storage is non-volative. That's their point in addition to RAM. HD are mechanical devices so they can't access info nearly as quickly as memory does. We use HDs because they are cheap and available. SSD are much faster alternatives to traditional HDs since they use integrated circuits.

LRU Cache

Least recently used cache. The objects that used the most stay in front of the queue.

```java
LRUCache = new LRUCache<String, Bitmap>();
```

Max amount of size needs to be set. It's like a special dictionary.

Requirements:

1. Fixed size: needs to have upper bound to limit memory usage

2. Fast access: cache insert and lookup should be fast, o(1) time

3. Replacement of entry in case, memory limit is reached

## What happens when you navigate to website

1. You enter the url into the browser www.facebook.com
2. The browser looks up the IP address for the domain name. The DNS lookup works as follows:

    - Browser cache (varies between 2 - 30 minutes)
    - OS cache
    - Router cache
    - ISP DNS cache
    - Recursive search

3. The browser sends a http request to the web server. Anatomy of a request:

  GET http://facebook.com/ HTTP/1.1
  Accept: application/x-ms-application, image/jpeg, application/xaml+xml, [...]
  User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; [...]
  Accept-Encoding: gzip, deflate
  Connection: Keep-Alive
  Host: facebook.com
  Cookie: datr=1265876274-[...]; locale=en_US; lsd=WW[...]; c_user=2101[...]

  The GET request names the url to fetch. The browser identifies itself with the user-agent header and states what will accept. The connection header asks the server to keep the TCP connection open for further requests.

  The request also contains cookies for the domain. Cookies are key value pairs that track state of a website.

4. The server responds with a permanent redirect

It tells the browser that it should use https://facebook.com

5. Browser follows redirect

Another get request is sent, but now to the redirected address. Header remain the same.

6. Server handles the request

The server receives the GET request, process it and send back a response. A LOT may happen here.

7. The server sends back a response

8. Browser begings rendering the html

9. Browser sends requests for objects embedded in html

Things like images, CSS, JS

10. The browser sends further ajax requests

## TCP VS UDP

Both are protocols for sending bits of data (packets) over the internet. They are both built on top of the internet protoccol (sent via IP).

### TCP

Stands for transmission control protocol. It is the most commonly used protocol. When page is loaded, computer sends TCP packets to web server's address asking it to send web data to you. The server responds with a stream of packets which is stitched together by the browser and displayed to you. TCP is not one one communication, the receiving end aknowledges that it has received packages. TCP guarantees the recipient will receive the packets in order by numbering them. If a package is not received, it will send it again. TCP is all about realibility.

### UDP

Stands for user datagram protocl. A datagram is the same as a packet of information. Works similarly as TCP, but there is no error checking. No back and forth communication that slows things down. Used when speed is desirable, more than error correction. Used for live broadcasting, streaming and gaming.

## Cookies

Small data packets used to save state and monitor activity. A cookie is a piece of text that a Web server can store on a user's hard disk. Cookies allow a Web site to store information on a user's machine and later retrieve it. The pieces of information are stored as name-value pairs.

## How to speed up website

- Db indices for common queries
- Better caching
- Loading front end assets using CDN
- Cleaning up zombie listeners
- Minimize http requests
- Minify and combine files
- Use lazy loading and async loading
- Minimize time to first byte - Server side thing
- Reduce server response time
- Switch dns provider
- Choose the right hosting - shared hosting, VPS hosting or dedicated
- Compress files
- Enable compression
- Enable browser caching
- Use external hosting platforms