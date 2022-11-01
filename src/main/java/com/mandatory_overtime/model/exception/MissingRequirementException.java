package com.mandatory_overtime.model.exception;

public class MissingRequirementException extends IllegalArgumentException {

  private String roomString;
  private String nextRoomPreReq;

  public MissingRequirementException(String noun, String nextRoomPreReq){
    this.roomString = noun;
    this.nextRoomPreReq = nextRoomPreReq;
  }

  public String getMessage(){
    return "You need " + nextRoomPreReq.toUpperCase() + " in your inventory to proceed to " + roomString.toUpperCase();
  }
}
