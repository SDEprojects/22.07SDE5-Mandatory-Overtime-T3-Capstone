package com.mandatory_overtime.model;

import com.google.gson.annotations.SerializedName;

public class Npc {

  //-------FIELDS ----------------//
  @SerializedName("location")
  private String location;//Can become array of rooms.
  @SerializedName("initialDialogue")
  private String initialDialogue;
  @SerializedName("dialogueNoItem")
  private String dialogueNoItem;
  @SerializedName("dialogueWithItem")
  private String dialogueWithItem;

  @SerializedName("initialAudio")
  private String initialAudio;

  @SerializedName("audioNoItem")
  private String audioNoItem;

  @SerializedName("audioWithItem")
  private String audioWithItem;

  @SerializedName("audioQuestDone")
  private String audioQuestDone;

  @SerializedName("itemsDropped")
  private String items;
  @SerializedName("NpcName")
  private String name;

  @SerializedName("dialogueQuestDone")
  private String dialogueQuestDone;

  @SerializedName("prereq")
  private String prereq;

  @SerializedName("interactionCount")
  private Integer npcCount;

  //---------GETTERS/SETTERS-------------//
  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getInitialDialogue() {
    return initialDialogue;
  }

  public void setInitialDialogue(String initialDialogue) {
    this.initialDialogue = initialDialogue;
  }

  public String getDialogueNoItem() {
    return dialogueNoItem;
  }

  public void setDialogueNoItem(String dialogueNoItem) {
    this.dialogueNoItem = dialogueNoItem;
  }

  public String getDialogueWithItem() {
    return dialogueWithItem;
  }

  public void setDialogueWithItem(String dialogueWithItem) {
    this.dialogueWithItem = dialogueWithItem;
  }

  public String getDialogueQuestDone() {
    return dialogueQuestDone;
  }

  public void setDialogueQuestDone(String dialogueQuestDone) {
    this.dialogueQuestDone = dialogueQuestDone;
  }

  public String getPrereq() {
    return prereq;
  }

  public void setPrereq(String prereq) {
    this.prereq = prereq;
  }

  public Integer getNpcCount() {
    return npcCount++;
  }

  public void setNpcCount(Integer npcCount) {
    this.npcCount = npcCount;
  }

  public String getInitialAudio() {
    return initialAudio;
  }

  public void setInitialAudio(String initialAudio) {
    this.initialAudio = initialAudio;
  }

  public String getAudioNoItem() {
    return audioNoItem;
  }

  public void setAudioNoItem(String audioNoItem) {
    this.audioNoItem = audioNoItem;
  }

  public String getAudioWithItem() {
    return audioWithItem;
  }

  public void setAudioWithItem(String audioWithItem) {
    this.audioWithItem = audioWithItem;
  }

  public String getAudioQuestDone() {
    return audioQuestDone;
  }

  public void setAudioQuestDone(String audioQuestDone) {
    this.audioQuestDone = audioQuestDone;
  }
}