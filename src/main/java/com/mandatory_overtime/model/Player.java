package com.mandatory_overtime.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**Represents user playing game. Maintains player state.**/
public class Player {


  private List<String> inventory = new ArrayList<>();
  private String name;
  private String currentLocation = "office";
  private int failCount;

  private int secondsRemaining;

  private int minutesRemaining;

  public List<String> getInventory() {
    return inventory;
  }

  public void setInventory(List<String> inventory) {
    this.inventory = inventory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

  public int getFailCount() {
    return failCount;
  }

  public void setFailCount(int failCount) {
    this.failCount = failCount;
  }

  public int getSecondsRemaining() {
    return secondsRemaining;
  }

  public void setSecondsRemaining(int secondsRemaining) {
    this.secondsRemaining = secondsRemaining;
  }

  public int getMinutesRemaining() {
    return minutesRemaining;
  }

  public void setMinutesRemaining(int minutesRemaining) {
    this.minutesRemaining = minutesRemaining;
  }

  /**
   * Adds to inventory for Player
   *
   * @param item input item from user to be added to inventory.
   */
  public void addToInventory(String item){
    inventory.add(item);
  }

  /**
   * Removes item from inventory for Player
   *
   * @param item
   */
  public void removeFromInventory(String item){
    inventory.remove(item);
  }
}
