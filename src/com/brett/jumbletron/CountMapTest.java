package com.brett.jumbletron;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by brett on 4/24/14.
 */
public class CountMapTest {

    @Test
    public void testConstructor() throws Exception {
        CountMap map = new CountMap("test");

        assertTrue(map.count('t').equals(2));
        assertTrue(map.count('e').equals(1));
        assertTrue(map.count('s').equals(1));
    }

    @Test
    public void testToString() throws Exception {
        CountMap map = new CountMap("test");

        String s = map.toString();
        assertTrue(s.equals("e1s1t2"));
    }

    @Test
    public void testToStringDifferentOrderSame() throws Exception {
        CountMap map = new CountMap("ttse");

        String s = map.toString();
        assertTrue(s.equals("e1s1t2"));
    }




}
