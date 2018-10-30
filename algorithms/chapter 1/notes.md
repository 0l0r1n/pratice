# Week 1

## Steps to developing an algorithm

- model the problem
- find an algorithm to solve it
- Fast enough? Fits in memory?
- If not, figure out why
- Find a way to address the problem
- Iterate until satisfied

## Union Find

Given a set of N objects

- Union command: connects two objects
- Find command: is there a path between two objects?

Modelling connections

- Reflexive: p is connected to p
- Symmetric: if p is connected to q, q is connected to p
- Transitive: if p is connected to q and q is connected to r, p is connected to r

Union-Find API

```java
public Interface IUF {
    UF(int N); // initiates the data structure
    void union(int p, int q); // adds connection between p and q
    boolean connected(int p, int q); // are p and q in the same component?
    int find(int p); // component identifier for p
    int count(); // number of components
}
```

## Quadradic algorithms don't scale

- A a brute force quick find on 10 a large data set could take 30 years to compute
- Quadratic algorithms do not scale with technology
