package com.brett.jumbletron;

import com.brett.utilities.Permutations;

import java.io.*;
import java.util.*;


/**
 * Created by brett on 4/24/14.
 */
public class AnagramJumbletron extends AbstractJumbletron {

    private Map<String, List<String>> anagramDictionary;

    public AnagramJumbletron(){
        anagramDictionary = populateDictionary();
    }

    /***
     *Compute the CountMap for each word.
     *
     * If the same CountMap has already been seen then we know it is anagram
     * of other words, add it to the anagram list.
     *
     * @param currWord
     */
    @Override
    protected void processDictionaryWord(String currWord) {
        CountMap countMap = new CountMap(currWord);
        List<String> strings;
        if (anagramDictionary.containsKey(countMap.toString())){
            strings = anagramDictionary.get(countMap.toString());
        }else{
            strings = new ArrayList<String>();
        }
        strings.add(currWord);
        anagramDictionary.put(countMap.toString(), strings);
    }

    /***
     * Given an input word, return all the words that can be made using all the characters from input
     * @param input
     * @return
     */
    public List<String> getAnangrams(String input){
        CountMap inputCountMap = new CountMap(input);
        return anagramDictionary.get(inputCountMap.toString());
    }

    /***
     * Compute all of the permutations of the input string.
     * For each permutation, fetch all of its angarams.
     *
     * @param input
     * @return
     */
    public Set<String> solve(String input) {

        Set<String> permutations = Permutations.getPermutations(input);

        Set<String> matchingWords = new HashSet<String>();
        for (String permutation : permutations) {
            matchingWords.addAll(this.getAnangrams(permutation));
        }

        return matchingWords;
    }
}
