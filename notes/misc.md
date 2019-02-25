# Misc subjects

## Signed integer vs Unsigned integer

A signed integer is an integer that could be both positive or negative. Unsigned integer can only be positive. A signed integer will have a 0 in the topmost bit for positive numbers and 1 for a negative number. Unsigned ints use the left most bit as part of the value. For an n-bit integer, the signed version can hold values from -2^(n-1) to 2^(n-1) - 1. The unsigned version can hold values from 0 to 2^n - 1.

## Quick select

Selection algorithm to find the kth smallest element in an unordered list. Runs on O(n) for average case and O(n^2) for worst.

## Median of medians

Approximate median selection algorithm. Used by quick select to search for a good pivot. Runs on O(n) for both best and worst cases.

## Databases

### SQL

Stands for structured query language. Used with RDBMS and RDSMS. Useful with structured data. Scope of SQL - data query, manipulation, definition and access control.

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

### NewSQL

## Bit Manipulation

### two's complement