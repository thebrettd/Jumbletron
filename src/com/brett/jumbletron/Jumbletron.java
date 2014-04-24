package com.brett.jumbletron;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
                processWord(currWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void processWord(String currWord) {
        //System.out.println(currWord);
    }

    public List<String> getWords(String c){
        return map.get(c);
    }


}
