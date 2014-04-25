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
     * Apply some precomputation algorithm..
     *
     * @return
     */
    protected Map<String, List<String>> populateDictionary() {
        HashMap<String, List<String>> anagramDict = new HashMap<String, List<String>>();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("com/brett/jumbletron/words.out");
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
