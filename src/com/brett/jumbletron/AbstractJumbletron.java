package com.brett.jumbletron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brett on 4/25/14.
 */
public abstract class AbstractJumbletron implements Jumbletron {
    /***
     * Iterate through each word in the dictionary file.
     * Compute the CountMap for each word.
     *
     * If the same CountMap has already been seen, we know it is anagram of other words, add it to the anagram list.
     *
     * @return
     */
    protected Map<String, List<String>> populateDictionary() {
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

    protected abstract void processDictionaryWord(String currWord);


}
