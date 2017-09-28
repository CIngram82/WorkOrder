package com.ChrisIngram;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Creator {
  public void createWorkOrders(){
    // read input, create work order and write to json files.
    // Loop
    Scanner sc = new Scanner(System.in);

    System.out.println("Please enter a description");
    String tempDesc = sc.nextLine();

    System.out.println("Your name here");
    String tempName = sc.nextLine();

    WorkOrder workOrder = new WorkOrder(tempDesc, tempName);

    File f = new File(workOrder.getId()+ ".json");

    try {
      FileWriter fw = new FileWriter(f);
      ObjectMapper mapper = new ObjectMapper();
      String json = mapper.writeValueAsString(workOrder);
      fw.write(json);
      fw.close();

    }catch (IOException e) {
      e.printStackTrace();
    }

  }
  // In Creator have a public static void main that creates an instance of
  // Creator and calls the instance method that loops to get the user
  // input and create work order files.

  public static void main(String args[]) {
   while (true){
     Scanner sc = new Scanner(System.in);
     System.out.println("Would you like to add a work order? Y/N");
     String userAnswer = sc.nextLine();
     if (userAnswer.equals("Y")) {
       Creator creator = new Creator();
       creator.createWorkOrders();
     } else{
       System.out.println("Goodbye!  you entered: " + userAnswer);
       break;
     }
    }
  }

}
