# Chapter 1 Notes

- An algorithm must solve a general, well specified problem
- An algorithmic problem is specified by describing the complete set of instances it must work on - your algorithm should solve them all otherwise it's incorrect. Distinction between a problem and instance of a problem.
- Example: Sorting is the problem to be solved. It could be sorting numbers or names. Insertion Sort is an algorithm that solves that problem
- An algorithm could be reasonable and yet it could be bad
- There is a fundamental difference between algorithms, which always produce a correct result, and heuristics which usually does a good job but does not provide a guarantee.
- Reasonable looking algorithms can easily be incorrect. Algorithm correctness is a property that must be carefully demonstrated.

## Algorithm correctness

- We need to distinguish correct from incorrect algorithms. Proof is the primary tool for that -> statement, assumptions, chain of reasoning and finally a demonstration.
- The heart of any algorithm is an idea. If your idea is not clearly revelead when you express an algorithm, then you are using too low-level a notation to describe it.
- An important and honorable technique in algorithm design is to narrow the set of allowable instances until there is a correct and efficient algorithm.
- To demonstrate incorrectness, we use counter examples. Two important aspects of counter examples are verifiability and simplicity.
- Recursion is mathematical induction