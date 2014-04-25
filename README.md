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

A Tree map is used so that iteration on keys is done in alphabetical order.
This ensures strings with the same characters in different order produce a CountMap with the same toString

### Wordlist

Words list provided by http://wordlist.sourceforge.net/

./mk-list -v2 american 95 > words.out

# Algorithms

### Attempt 1

* Pre-compute the anagram of every word in the dictionary.
* Given a string as input, compute all of the permutations of the input string.
* For each permutation, fetch all of its angarams from the precomputed list.

This algorithm does not scale well for long input, as the cost of computing all the permutations grows

### Attempt 2

* Precompute a map. The Key is a letter count, the value is the list of all known words that can be composed using that many letters.
* Given a string as input, compute the CountMap.
    * For each entry, fetch all of the words that can be computed using that many letters or fewer
    * Compute the CountMap of each word in that list. If input word has at least as many occurrences of every character then add it to our result list.

This algorithm is greedy in terms of memory usage, since a single dictionary word will be in multiple lists.
However, it can handle arbitrary length input.


