package com.brett.jumbletron;

import com.brett.utilities.Permutations;

import java.io.*;
import java.util.*;


/**
 * Created by brett on 4/24/14.
 */
public class AnagramJumbletron implements Jumbletron {

    private Map<String, List<String>> anagramDictionary;

    public AnagramJumbletron(){
        anagramDictionary = populateDictionary();
    }

    private Map<String, List<String>> populateDictionary() {
        HashMap<String, List<String>> anagramDict = new HashMap<String, List<String>>();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("words.out");
        InputStreamReader reader = new InputStreamReader(resourceAsStream);
        BufferedReader br = new BufferedReader(reader);

        String currWord;
        try {
            while ((currWord = br.readLine()) != null) {
                processDictionaryWord(currWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return anagramDict;
    }

    /***
     *
     * @param currWord
     */
    private void processDictionaryWord(String currWord) {
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
