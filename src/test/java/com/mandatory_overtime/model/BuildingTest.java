package com.mandatory_overtime.model;

import static com.mandatory_overtime.model.GameMusic.player;
import static org.junit.Assert.*;

import com.mandatory_overtime.model.Building.CantGetItemException;
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


    @Test
    public void testGetAllItems() throws IOException, InterruptedException, CantGetItemException {
        String noun = "";
        building.createGameStructureFromNew("easy");
        building.setName("olu");
        building.getAllItems(noun);
        HashMap<String, Item> items = building.getGameItems();
        System.out.println(items.size());
        int expected = items.size();
        int actual = 10;
        assertEquals(expected, actual);

    }





}
