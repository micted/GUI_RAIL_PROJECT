/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.functions;

import gui_railway_project.Connection;
import gui_railway_project.Station;
import java.util.List;
import gui_railway_project.Trainset;
import gui_railway_project.functions.RailwayNetwork;

public class TrainReturn implements Runnable {
    private final Trainset trainset;
    private final RailwayNetwork railwayNetwork;
    private final List<Connection> segments;
    private Connection currentSegment;
    

    public TrainReturn(Trainset trainset, List<Connection> segments, Connection currentSegment, RailwayNetwork railwayNetwork) {
        this.trainset = trainset;
        this.segments = segments;
        this.currentSegment = currentSegment;
        this.railwayNetwork = railwayNetwork;
    }

    @Override
    public void run() {
        try {
            // Wait for 30 seconds
            Thread.sleep(30000);

            // Generate a new route for the train
            List<String> newRoute = railwayNetwork.findRoute(currentSegment.getEndStation().getName(),railwayNetwork.getRandomAdjacentStation(currentSegment.getEndStation()));
            TrainSegment newSegment = new TrainSegment(trainset, segments, railwayNetwork, railwayNetwork.calculateDistance(newRoute));

            // Start the new segment in a new thread
            Thread newThread = new Thread(newSegment);
            newThread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

