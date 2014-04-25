Jumbletron
==========


jumbletron is a command line program for solving word jumbles.

Given a word as input, it will print out all known words which can be created using any or all of the characters from
that input word.

Code is included for 2 different algorithms, but the program currently will only execute the second algorithm, which
performed better for longer input strings.

# Usage

javac Main.java
java Main

# Glossary

### Jumbletron

An Interface for objects which can solve word jumbles

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

I generated the words list using the following parameters:

Category: american
Size: 95 (insane)
Variants: 2

./mk-list -v2 american 95 > words.out

In retrospect, this was probably not the best choice as this list contains many unusual one letter words and acronyms

# Algorithms

### Attempt 1

* Pre-compute the anagram of every word in the dictionary.
* Given a string as input, compute all of the permutations of the input string.
* For each permutation, fetch all of its anagrams from the precomputed list.

This algorithm does not scale well for long input, as the cost of computing all the permutations grows

### Attempt 2

* Pre-compute a map. The Key is a letter count, the value is the list of all known words that can be composed using that many letters.
* Given a string as input, compute the CountMap.
    * For each entry, fetch all of the words that can be computed using that many letters or fewer
    * Compute the CountMap of each word in that list. If input word has at least as many occurrences of every character then add it to our result list.

This algorithm is greedy in terms of memory usage, since a single dictionary word will be in multiple lists.
However, it can handle arbitrary length input.


