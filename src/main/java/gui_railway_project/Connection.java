/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project;


import gui_railway_project.Station;

public class Connection {
    
    // a code to ID a connection b/n two stations
    private String connectionCode;
    private Station startStation;
    private Station endStation;

    public Connection(String connectionCode, Station startStation, Station endStation) {
        this.connectionCode = connectionCode;
        this.startStation = startStation;
        this.endStation = endStation;
    }
    
    public String getconnectionCode() {
        return this.connectionCode;
    }

    public Station getStartStation() {
        return this.startStation;
    }

    public Station getEndStation() {
        return this.endStation;
    }

    public double getDistance() {
        double x1 = startStation.getLatitude();
        double y1 = startStation.getLongitude();
        double x2 = endStation.getLatitude();
        double y2 = endStation.getLongitude();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}

