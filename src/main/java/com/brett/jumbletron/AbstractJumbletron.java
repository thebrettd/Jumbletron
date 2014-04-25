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
     * Apply some pre-computation algorithm..
     *
     * @return
     */
    protected void processDictionary() {
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

    protected abstract void processDictionaryWord(String currWord);


}
