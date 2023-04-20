/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.functions;

/**
 *
 * @author Hp
 */
import java.util.*;
import gui_railway_project.Station;
import gui_railway_project.Connection;

public class RailwayNetwork {
       private Map<String, List<Connection>> adjacencyList;
    private Map<String, Object> locks;

    public RailwayNetwork() {
        this.adjacencyList = new HashMap<>();
        this.locks = new HashMap<>();
    }
    
    public boolean hasStation(String stationName) {
        return adjacencyList.containsKey(stationName);
    }


    public void addStation(Station station) {
        if (!adjacencyList.containsKey(station.getName())) {
            adjacencyList.put(station.getName(), new ArrayList<>());
        }
    }
    
    public String getRandomAdjacentStation(Station station) {
        List<Connection> adjacentStations = adjacencyList.get(station.getName());
        int randomIndex = new Random().nextInt(adjacentStations.size());
        Connection randomStationName = adjacentStations.get(randomIndex);
        return randomStationName.getEndStation().getName();
    }



    public void addConnection(Connection connection) {
        Station station1 = connection.getStartStation();
        Station station2 = connection.getEndStation();
        addStation(station1);
        addStation(station2);
        adjacencyList.get(station1.getName()).add(connection);
        adjacencyList.get(station2.getName()).add(connection);
        String track = getTrack(station1.getName(), station2.getName());
        if (!locks.containsKey(track)) {
            locks.put(track, new Object());
        }
    }

    // ITERATIVE DFS APPROACH TO DETERMINE ROUTE BETWEEN TWO NODES(STATIONS)
    public List<String> findRoute(String startStation, String endStation) {
        Map<String, String> visited = new HashMap<>();
        Map<String, Double> distances = new HashMap<>();
        Stack<String> stack = new Stack<>();
        stack.push(startStation);
        visited.put(startStation, null);
        distances.put(startStation, 0.0);

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (current.equals(endStation)) {
                List<String> route = reconstructPath(visited, endStation);
                double distance = calculateDistance(route);
                return route;
            }

            for (Connection connection : adjacencyList.get(current)) {
                String neighbor = connection.getStartStation().getName().equals(current) ? connection.getEndStation().getName() : connection.getStartStation().getName();
                double distanceToNeighbor = distances.get(current) + connection.getDistance();
                if (!visited.containsKey(neighbor) || distanceToNeighbor < distances.get(neighbor)) {
                    visited.put(neighbor, current);
                    distances.put(neighbor, distanceToNeighbor);
                    stack.push(neighbor);
                }
            }
        }

        return null;
    }

    private List<String> reconstructPath(Map<String, String> visited, String endStation) {
        List<String> path = new ArrayList<>();
        String current = endStation;
        while (current != null) {
            path.add(current);
            current = visited.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    public double calculateDistance(List<String> route) {
        double distance = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            String station1 = route.get(i);
            String station2 = route.get(i + 1);
            Connection connection = findConnection(station1, station2);
            if (connection != null) {
                distance += connection.getDistance();
            }
    }
    return distance;
}


    public Connection findConnection(String station1, String station2) {
        for (Connection connection : adjacencyList.get(station1)) {
            if (connection.getStartStation().getName().equals(station2) || connection.getEndStation().getName().equals(station2)) {
                return connection;
            }
        }
        return null;
    }
    
    public int calculateNumStops(List<String> route) {
        return route.size() - 2;
        
    }

    private String getTrack(String station1, String station2) {
        return station1.compareTo(station2) < 0 ? station1 + "-" + station2 : station2 + "-" + station1;
    }

    public Object getLockForTrack(String station1, String station2) {
        String track = getTrack(station1, station2);
        return locks.get(track);
    }
}
