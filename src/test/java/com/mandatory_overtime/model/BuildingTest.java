package com.mandatory_overtime.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import org.junit.Test;

public class BuildingTest {

    Building building;

    {
        try {
            building = new Building();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createGameStructureFromNewCreatesRooms() throws IOException {
        building.createGameStructureFromNew("easy");
        Room room = building.getBuilding().get("office");
        assertEquals(room.getClass(), building.getBuilding().get("office").getClass());
    }
    @Test
    public void createGameStructureFromNewCreatesItems() throws IOException {
        building.createGameStructureFromNew("easy");
        HashMap<String, Item> items = building.getGameItems();
        assertTrue(items.size() > 0);
    }



}