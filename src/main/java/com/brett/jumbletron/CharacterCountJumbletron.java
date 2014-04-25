package com.brett.jumbletron;

import com.brett.utilities.*;

import java.util.*;

/**
 *
 * Precompute a map:
 *  The Key is a letter count
 *  The value is the list of all known words that can be composed using that many letters.
 *
 *  Given a string as input, compute the CountMap for input
 *  For each character+count in that CountMap:
 *      fetch all of the words that can be computed using that many letters (or fewer!). These are potential words.
 *
 *  For each potential word:
 *      Compute potentialWordCountMap
 *      If input word has at least as many occurrences of every character then add it to our result list.
 *
 * Created by brett on 4/25/14.
 */
public class CharacterCountJumbletron extends AbstractJumbletron {

    private Map<String, List<String>> wordsByCharacterCount;

    public CharacterCountJumbletron(){
        wordsByCharacterCount = new HashMap<String, List<String>>();
        populateDictionary();
    }

    @Override
    protected void processDictionaryWord(String currWord) {
        CountMap currWordCounts = new CountMap(currWord);

        for ( Character c: currWordCounts.keySet()){
            String charCount = c + currWordCounts.get(c).toString();

            List<String> strings;
            if(wordsByCharacterCount.containsKey(charCount)){
                strings = wordsByCharacterCount.get(charCount);
            }else{
                strings = new ArrayList<String>();
            }
            strings.add(currWord);
            wordsByCharacterCount.put(charCount,strings);
        }
    }

    @Override
    public Set<String> solve(String input) {

        CountMap inputCountMap = new CountMap(input);

        List<String> potentialWords = findPotentialWords(inputCountMap);

        Set<String> foundWords = filterPotentialWords(inputCountMap, potentialWords);

        return foundWords;
    }

    private Set<String> filterPotentialWords(CountMap inputCountMap, List<String> potentialWords) {
        Set<String> foundWords = new HashSet<String>();

        for(String potentialWord : potentialWords){
            CountMap potentialWordCountMap = new CountMap(potentialWord);
            boolean possibleMatch = true;
            for (Character c: potentialWordCountMap.keySet()){
                if ( potentialWordCountMap.count(c) > inputCountMap.count(c)){
                    possibleMatch = false;
                }
            }

            if (possibleMatch){
                foundWords.add(potentialWord);
            }
        }

        return foundWords;
    }

    private List<String> findPotentialWords(CountMap inputCountMap) {
        List<String> potentialWords = new ArrayList<String>();
        for (Character c: inputCountMap.keySet()){
            Integer count = inputCountMap.get(c);
            for (int i=1; i <= count; i++){
                String charCount = c + count.toString();
                potentialWords.addAll(wordsByCharacterCount.get(charCount));
            }
        }
        return potentialWords;
    }
}
