package com.brett.utilities;

import java.util.*;

/**
 * Created by brett on 4/24/14.
 */
public class Permutations {

    public static Set<String> getPermutations(String input) {
        return getPermutations("", input, new HashSet<String>());
    }


    private static Set<String> getPermutations(String prefix, String input, Set<String> permutations) {
        if (prefix.length() > 0){
            permutations.add(prefix);
        }

        if (input.length() > 0){
            for (int i=0; i<input.length(); i++){
                String newPrefix = prefix + input.charAt(i);
                String remainingChars = removeCharAt(input, i);
                permutations.addAll(getPermutations(newPrefix, remainingChars, permutations));
            }
        }

        return permutations;
    }

    public static String removeCharAt(String input, int i) {
        if (input.equals("")){
            throw new IllegalStateException("Input cannot be empty");
        }
        if (i > input.length()){
            throw new ArrayIndexOutOfBoundsException("Ith character does not exist");
        }

        return input.substring(0,i) + input.substring(i+1,input.length());
    }
}
