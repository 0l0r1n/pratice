# Remember

Given a string - is this an ASCII string or Unicode string?
In a permutation, are chars case sensistive?
Is whitespace important?

Palindrome - a string that is the same forwards and backwards. To know if a string is a permutation of a palindrome, we need to know if we can write it the same backwards and forwards. Conditions:

- Even number of almost all chars so that half can be on one side and half can be on the other
- At most, only one char in the middle can have an odd count.

To be more precise, strings with even length, after removing all non letter chars, must have all even counts of characters. Strings of odd length may have a single odd char in the middle.

Sometimes, you don't need to count. You just need to know the odds and evens.

In the context of computing, a vector is a linear sequence of numeric values that are stored contiguously in memory. A bit vector is a vector in which each element is a bit (so its value is either 0 or 1).