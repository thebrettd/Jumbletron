Jumbletron
==========

# Glossary

### Jumbletron
An object to solve word jumbles. Input is a dictionary of valid words.

public List<String> getWords(String input)


public Set<String> solve(String input)


### CountMap
A map data structure computed from a single word input.
Tells you how many times a character occurred in a word.

Key = Character
Value = Integer representing how many times that Key occurred in the input string.

### Wordlist

Words list provided by http://wordlist.sourceforge.net/

./mk-list -v2 american 95 > words.out

# Algorithms

### Attempt 1

* Compute all of the permutations of the input string.
* For each permutation, fetch all of its angarams.

This algorithm does not scale well for long input, as the cost of computing all the permutations grows


