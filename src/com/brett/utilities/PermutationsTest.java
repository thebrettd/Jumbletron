package com.brett.utilities;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;


/**
 * Created by brett on 4/24/14.
 */
public class PermutationsTest {
    @Test
    public void testGetPermutations() throws Exception {
        Set<String> permutations = Permutations.getPermutations("ab");
        assertTrue(permutations.size() == 4);
    }

    @Test
    public void testremoveCharAt() throws Exception {
        String input = "abc";
        assertTrue(Permutations.removeCharAt(input, 0).equals("bc"));
        assertTrue(Permutations.removeCharAt(input, 1).equals("ac"));
        assertTrue(Permutations.removeCharAt(input, 2).equals("ab"));

        input = "abcd";
        assertTrue(Permutations.removeCharAt(input, 0).equals("bcd"));
        assertTrue(Permutations.removeCharAt(input, 1).equals("acd"));
        assertTrue(Permutations.removeCharAt(input, 2).equals("abd"));
        assertTrue(Permutations.removeCharAt(input, 3).equals("abc"));

        input = "a";
        assertTrue(Permutations.removeCharAt(input, 0).equals(""));


    }



}
