package com.ChrisIngram;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Processor {
  Map<Status, Set<WorkOrder>> woMap = new HashMap<>();


  public void processWorkOrders() throws IOException {
    try {
      Thread.sleep(5000l);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Have a map with Status as the key and a Set of work orders for the value
    //    Print out the map
    //    Move work orders
    moveIt();
    readIt();

    //print out the map
  }

  private void moveIt() {
    // move work orders in map from one state to another
  }

  private void readIt() throws IOException {
    File file = new File(".");

    for (File currentFile : file.listFiles()) {
      if (currentFile.getName().endsWith(".json")) {

        String fileJson = getDataFromFile(currentFile);
        ObjectMapper om = new ObjectMapper();
        WorkOrder wo = om.readValue(fileJson, WorkOrder.class);
        woMap.putIfAbsent(wo.getStatus(),  new HashSet<>());

      }
    }


    // read the json files into WorkOrders and put in map
  }

  private static String getDataFromFile(File f) throws FileNotFoundException {
    Scanner fileScanner = new Scanner(f);

    String results = "";
    String temp = fileScanner.nextLine();
    results += temp;

    return results;
  }

  public static void nextStep(WorkOrder wo) {
    Status currentStatus = wo.getStatus();
    switch (currentStatus) {
      case INITIAL:
        wo.setStatus(Status.ASSIGNED);
        break;
      case ASSIGNED:
        wo.setStatus(Status.IN_PROGRESS);
        break;
      case IN_PROGRESS:
        wo.setStatus(Status.DONE);
        break;
      default:
        break;
    }
  }


  public static void main(String args[]) throws IOException {
    while (true) {
      Processor processor = new Processor();
      processor.processWorkOrders();
    }
  }
}


