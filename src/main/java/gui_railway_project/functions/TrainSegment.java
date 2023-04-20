/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.functions;

/**
 *
 * @author Hp
 */
import java.util.List;
import java.util.concurrent.locks.Lock;
import gui_railway_project.Locomotive;
import gui_railway_project.Station;
import gui_railway_project.Connection;
import gui_railway_project.RailroadCars.*;
import gui_railway_project.Trainset;
import java.util.ArrayList;
import gui_railway_project.functions.RailwayNetwork;
import gui_railway_project.Exception.RailroadHazard;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TrainSegment implements Runnable {
    private final Trainset trainset;
    private final List<Connection> segments;
    private final RailwayNetwork railwayNetwork;
    private int currentSegmentIndex;
    private boolean isRunning;
    private int numStops;
    private double currentSpeed;
    private double currentDistanceCovered;
    private double totalDistanceCovered;
    private double routeDistance;

    public TrainSegment(Trainset trainset, List<Connection> segments, RailwayNetwork railwayNetwork,double routeDistance) {
        this.trainset = trainset;
        this.segments = segments;
        this.railwayNetwork = railwayNetwork;
        this.currentSegmentIndex = 0;
        this.isRunning = true;
        this.numStops = 0;
        this.currentSpeed = trainset.getSpeed();
        this.currentDistanceCovered = 0;
        this.totalDistanceCovered = 0;
        
    }

    public void run() {
        while (isRunning) {
            try {
                

                // Get current segment and next segment
                Connection currentSegment = segments.get(currentSegmentIndex);
                System.out.println("current segment is on"+currentSegment.getconnectionCode());
                // Get lock for current segment
                Lock lock = currentSegment.getLock();
                lock.lock();
                
                Connection nextSegment = currentSegmentIndex < segments.size() - 1 ? segments.get(currentSegmentIndex + 1) : null;

                // Calculate the distance remaining on the current segment
                double distanceRemaining = currentSegment.getDistance() - currentDistanceCovered;
                System.out.println("remaining distance till next segment"+distanceRemaining);

                // Calculate the time required to cover the remaining distance
                double timeRequired = distanceRemaining / currentSpeed;

                // Wait for the required time to simulate train movement
                Thread.sleep((long) (timeRequired * 1000));

                // Calculate the new distance covered and update the total distance covered
                currentDistanceCovered = currentSegment.getDistance();
                totalDistanceCovered += currentDistanceCovered;
                
                System.out.println(totalDistanceCovered);

                // Check if the train has arrived at a station
                if (currentSegment.hasStation()) {
                    // Stop at the station for 2 seconds
                    Thread.sleep(2000);
                    System.out.println("waiting 2 seconds");
                    numStops++;
                }

                // Calculate the new speed of the train based on the next segment and assign the new speed to the trainset
                if (nextSegment != null) {
                    double newSpeed = 80;
                    double speedChange = currentSpeed * 0.03 * (Math.random() > 0.5 ? 1 : -1);
                    newSpeed = Math.max(0.0, newSpeed + speedChange); // Make sure speed is not negative
                    currentSpeed = newSpeed;
                    trainset.setSpeed(currentSpeed);
                }

                // Move the trainset to the next segment
                if (nextSegment != null) {
                    try {
                        trainset.move(nextSegment, trainset.getSpeed());
                        System.out.println("moving");
                    } catch (RailroadHazard ex) {
                        Logger.getLogger(TrainSegment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    currentDistanceCovered = 0;
                    currentSegmentIndex++;
                } else {
                    isRunning = false; // Train has arrived at the destination
                    System.out.println("Desitnation arrived! Number of stops were"+" "+numStops);
                    List<String> newRoute = railwayNetwork.findRoute(currentSegment.getEndStation().getName(),railwayNetwork.getRandomAdjacentStation(currentSegment.getEndStation()));
                    TrainReturn returnHandler = new TrainReturn(trainset, segments, currentSegment, railwayNetwork);
                    Thread returnThread = new Thread(returnHandler);
                    returnThread.start();
                    System.out.println("waiting 30 sec");
                    System.out.println("returning back");
                    
                }

                // Release lock for current segment
                lock.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getCurrentDistanceCovered() {
        return currentDistanceCovered;
    }

    public double getTotalDistanceCovered() {
        return totalDistanceCovered;
    }
}

