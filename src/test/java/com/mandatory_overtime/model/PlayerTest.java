package com.mandatory_overtime.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private final Player testPlayer = new Player();

    @Before
    public void setUp() throws Exception {
        testPlayer.setName("Test Player Name");
        String testItem1 = "test item 1";
        testPlayer.addToInventory(testItem1);
    }

    @Test
    public void testAddToInventory() {
        String testItem2 = "test item 2";
        testPlayer.addToInventory(testItem2);
        assertEquals(2, testPlayer.getInventory().size());
        assertTrue(testPlayer.getInventory().contains(testItem2));
    }

    @Test
    public void testRemoveFromInventory() {
        assertTrue(testPlayer.getInventory().contains("test item 1"));
        testPlayer.removeFromInventory("test item 1");
        assertFalse(testPlayer.getInventory().contains("test item 1"));
        assertEquals(0, testPlayer.getInventory().size());
    }

//    @Test
//    public void testRemoveNull
}