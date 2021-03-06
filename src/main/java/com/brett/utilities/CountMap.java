package com.brett.utilities;

import java.util.TreeMap;

/**
 * Simple wrapper class. Given a String, compute a map of frequencies of each character
 *
 * A tree map is used so that iteration on keys is done in alphabetical order.
 * This ensures strings with the same characters in different order produce a CountMap with the same toString
 *
 */
public class CountMap extends TreeMap<Character, Integer> {

    public CountMap(String input){
        super();

        for (int i=0; i<input.length(); i++){
            char currChar = input.charAt(i);
            if (this.containsKey(currChar)){
                int oldCounter = this.get(currChar);
                this.put(currChar, ++oldCounter);
            }else{
                this.put(currChar, 1);
            }
        }
    }

    public Integer count(char t) {
        Integer integer = this.get(t);
        return integer == null ? 0 : integer;
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();

        for(Character c: this.keySet()){
            b.append(c).append(this.get(c).toString());
        }
        return b.toString();
    }
}
