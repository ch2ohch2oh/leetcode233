# Problems by categories

## Union-find

## DP

- [4 Regular expression matching](https://leetcode.com/problems/regular-expression-matching/)
  Reg matching with star and dot. Use memoization.
- [32 Longest valid parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
  The first method is to use `longest[i]` to save the longest valid string 
  ending at index `i`. The other method is to use stack.
- [44 Wildcard matching](????)
- [45 Jump II](https://leetcode.com/problems/jump-game-ii/)
  The O(N^2) solution is easy to come up with.
  The O(N) one takes some thought. It is similar to two pointers.
- [53 Maximum subarray](https://leetcode.com/problems/maximum-subarray/)
  Simple 1D max continuous subarray.
- [198 House robber](https://leetcode.com/problems/house-robber/)
  Simple one dimensional DP where the current best answer
  depends on the previous answers.
- [213 House robber II](https://leetcode.com/problems/house-robber-ii/)
  Compare two cases: rob the first house and no rob. Then solve 
  as 198.
- 1326
- 1024
- 139
- 140
- 300
- 132



## Greedy

- [5 Longest palindromic substring](https://leetcode.com/problems/longest-palindromic-substring/)
  Start at index `i` and search to the left and right.
- [55 Jump game](https://leetcode.com/problems/jump-game/)
  O(N) scan of the array.


## Recursion

- [22 Generate parentheses](https://leetcode.com/problems/generate-parentheses/)
  One can use memoization to make it slightly faster.

## Stack

- [20 Valid parentheses](https://leetcode.com/problems/valid-parentheses/)
  Use stack.

## Hashmap

- [1 Two sum](https://leetcode.com/problems/two-sum/)
  Use a hashmap to store the index of a number.

## Array

- [2 Add two numbers](https://leetcode.com/problems/add-two-numbers/)
  Add two numbers stored as two lists.

## Two pointers

- [3 Longest substring without repeating characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
  Enumerate the ending index of the longest substring.
