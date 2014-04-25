package com.brett.jumbletron;

import com.brett.utilities.Permutations;

import java.io.*;
import java.util.*;


/**
 * Created by brett on 4/24/14.
 */
public class Jumbletron {

    private Map<String, List<String>> map;

    public Jumbletron(){
        map = new HashMap<String, List<String>>();

        populateDictionary();

    }

    private void populateDictionary() {

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
    }

    private void processDictionaryWord(String currWord) {
        CountMap countMap = new CountMap(currWord);
        List<String> strings;
        if (map.containsKey(countMap.toString())){
            strings = map.get(countMap.toString());
        }else{
            strings = new ArrayList<String>();
        }
        strings.add(currWord);
        map.put(countMap.toString(),strings);
    }

    /***
     * Given an input word, return all the words that can be by the characters of that word
     * @param input
     * @return
     */
    public List<String> getWords(String input){
        CountMap inputCountMap = new CountMap(input);
        return map.get(inputCountMap.toString());
    }


    public Set<String> solve(String input) {
        Set<String> matchingWords = new HashSet<String>();
        Set<String> combinations = Permutations.getPermutations(input);
        for (String permutation : combinations) {
            matchingWords.addAll(this.getWords(permutation));
        }
        return matchingWords;
    }
}
