package com.ChrisIngram;

public class WorkOrder {
  private static int idCounter;
  private int id;
  private String description;
  private String senderName;
  private Status status;

  public WorkOrder( String description, String senderName) {
    this.id = idCounter;
    idCounter++;
    this.description = description;
    this.senderName = senderName;
    this.status = Status.INITIAL;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
