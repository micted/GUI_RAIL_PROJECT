/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.functions;


import java.util.*;
import gui_railway_project.Trainset;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.List;
import gui_railway_project.functions.RailwayNetwork;
import gui_railway_project.functions.TrainSegment;



/**
 *
 * @author Hp
 */
public class AppStateUpdater extends Thread {
    private ArrayList<Trainset> trainsets;

    public AppStateUpdater(ArrayList<Trainset> trainsets) {
        this.trainsets = trainsets;
    }

    public void run() {
        while (true) {
            try {
                // Sleep for 5 seconds
                Thread.sleep(5000);
                
                // this sorts the trainsets list according to custom defined trainset comparator class
                Collections.sort(trainsets, new TrainsetComparator());               

                // Write trainset information to AppState.txt file
                FileWriter fileWriter = new FileWriter("C:\\Users\\Hp\\Documents\\PJAIT documents\\GUI\\GUI_Railway_Project\\src\\main\\java\\gui_railway_project\\AppState.txt");
                for (Trainset trainset : trainsets) {
                    fileWriter.write(trainset.trainsetInfoStr() + "\n");
                }
                fileWriter.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
