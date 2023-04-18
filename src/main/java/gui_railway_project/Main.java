/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project;


import java.util.Scanner;
import gui_railway_project.Locomotive;
import gui_railway_project.Station;
import gui_railway_project.Connection;
import gui_railway_project.RailroadCars.*;
import gui_railway_project.Trainset;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        // later we need to select trainset inorder to attach cars
        Trainset selectedTrain = null;
        // select a car to attach it to a trainset
        RailroadCar selectedCar = null;
        // select a station to connect
        Station selectedstartStation = null;
        // select a station to connect
        Station selectedendStation = null;
        
        
        Locomotive locomotive = null;
        RailroadCar railroadCar = null;
        
        // store created trainsets
        ArrayList<Trainset> trainsets = new ArrayList<>();
        // store created locomotives
        ArrayList<Locomotive> locomotives = new ArrayList<>();
        // store created railroadcars
        ArrayList<RailroadCar> railroadcars = new ArrayList<>();
        // available stations list
        ArrayList<Station> stations = new ArrayList<>();
        // available connections list
        ArrayList<Connection> connections = new ArrayList<>();
        
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create a new object");
            System.out.println("2. List car ");
            System.out.println("3. List train ");
            System.out.println("4. attach car ");
            System.out.println("5. Quit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSelect an object to create:");
                    System.out.println("1. Trainset&Loco");
                    System.out.println("2. Railroad Car"); 
                    System.out.println("3. Station"); 
                    System.out.println("4. Connection"); 
                    System.out.println("0. GoBack");
                    int objectChoice = scanner.nextInt();
                    scanner.nextLine(); // clear the buffer
                    
                    if (objectChoice == 0) {
                        continue; // go back to the previous loop iteration
                    }


                    switch (objectChoice) {
                        case 1:
                            System.out.println("Enter the name:");
                            String name = scanner.nextLine();
                            System.out.println("\nEnter the maximum number of railroad cars:");
                            int maxRailroadCars = scanner.nextInt();
                            System.out.println("Enter the max of e car:");
                            int maxElectricCars = scanner.nextInt();
                            System.out.println("Enter the maximum weight:");
                            int maxWeight = scanner.nextInt();                            
                            scanner.nextLine(); // clear the buffer
                            System.out.println("Enter the home station:");
                            String homeStation = scanner.nextLine();
                            System.out.println("Enter the source station:");
                            String sourceStation = scanner.nextLine();
                            System.out.println("Enter the destination station:");
                            String destinationStation = scanner.nextLine();
                            locomotive = new Locomotive(name, maxRailroadCars, maxWeight, maxElectricCars, homeStation, sourceStation, destinationStation);
                            locomotives.add(locomotive);
                            
                            Trainset trainset = new Trainset(locomotive);                            
                            trainsets.add(trainset);
                            
                            System.out.println("\nLocomotive created: " + locomotives);
                            System.out.println("\trainset created: " + trainsets);
                            break;
                        case 2:                            
                            System.out.println("\nEnter the type of the railroad car:");
                            System.out.println("1. Passenger railroad car");
                            System.out.println("2. Railroad post office");
                            System.out.println("3. Railroad baggage and mail car");
                            System.out.println("4. Railroad restaurant car");
                            System.out.println("5. Basic railroad freight car");
                            System.out.println("6. Heavy railroad freight car");
                            System.out.println("7. Refrigerated railroad car");
                            System.out.println("8. Railroad car for liquid materials");
                            System.out.println("9. Railroad car for gaseous materials");
                            System.out.println("10. Railroad car for explosives");
                            System.out.println("11. Railroad car for toxic materials");
                            System.out.println("12. Railroad car for liquid, toxic material");
                            int typeChoice = scanner.nextInt();
                            scanner.nextLine(); // clear the buffer
                            System.out.println("Enter the net weight:");
                            int carWeight = scanner.nextInt();
                            scanner.nextLine(); // clear the buffer
                            System.out.println("Enter the gross weight:");
                            int maxCargoWeight = scanner.nextInt();
                            scanner.nextLine(); // clear the buffer
                            
                            switch (typeChoice) {
                                case 1:
                                    System.out.println("Enter the number of seats:");
                                    int numSeats = scanner.nextInt();
                                    scanner.nextLine(); // clear the buffer
                                    
                                    PassengerRailroadCar passengerRailroadCar = new PassengerRailroadCar(carWeight,maxCargoWeight, numSeats);
                                    railroadCar = passengerRailroadCar;
                                    railroadcars.add(railroadCar);
                                    break;
                                default:
                                    System.out.println("\nInvalid choice");
                                    break;                                  
                            }
                            break;
                                                  
                        
                        case 3:
                                                       
                            System.out.println("Enter the station name:");
                            String stationName = scanner.nextLine();
                            System.out.println("Enter the latitude value or X-coordinate:");
                            double lat = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Enter the longitude value or Y-coordinate:");
                            double lon = scanner.nextDouble();
                            
                            Station station = new Station(stationName,lat,lon);
                            stations.add(station);
                            break;
                            
                            
                        case 4:
                            
                            System.out.println("=== Here are a list of available stations ===");
                            
                            for (Station eachstation : stations) {
                                
                                System.out.println(eachstation.getName());
                                
                            }
                            System.out.println("Enter the start station name:");
                            String start = scanner.nextLine();
                            for (Station eachstation : stations) {
                                
                                if (eachstation.getName().equals(start)){
                                    
                                    selectedstartStation = eachstation;
                                    
                                };
                                
                            }
                            
                            System.out.println("Enter the end station name:");
                            String end = scanner.nextLine();
                            for (Station eachstation : stations) {
                                
                                if (eachstation.getName().equals(end)){
                                    
                                    selectedendStation = eachstation;
                                    
                                };
                                
                            }
                            System.out.println("Enter the name/code for the connection:");
                            String connectionCode = scanner.nextLine();
                            
                            Connection conn = new Connection(connectionCode,selectedstartStation,selectedendStation);
                            connections.add(conn);
                            System.out.println(connections.get(0).getconnectionCode());
                            
                            break;                         
                            
                            
                        

                        default:
                            System.out.println("\nInvalid choice");
                            break;
                    }
                    break;
                case 2:
                                       
                    System.out.println("=== List A CAR ===");
                                             
                    for (RailroadCar car : railroadcars) {
                        System.out.println(car.getUniqueNum());                                
                    } 
                    break;
                case 3:
                                       
                    System.out.println("=== list A TRAIN ===");
                                             
                    for (Trainset train : trainsets) {
                        System.out.println(train.id);      
                        
                    } 
                    
                    
                    
                    break;
                
                case 4:
                                        
                    System.out.println("Enter the ID of a trainset:");
                    int selectedtrainID = scanner.nextInt();
                    scanner.nextLine(); // clear the buffer
                    System.out.println("Enter the ID of a car you want to attach");
                    String selectedcarID = scanner.nextLine();
                    for (Trainset train : trainsets) {
                        if (train.id==selectedtrainID) {        
                            selectedTrain = train;
                            System.out.println("Selected trainset: " + train);                            
                        }
                    }
                    for (RailroadCar car : railroadcars) {
                        if (car.getUniqueNum().equals(selectedcarID)) {        
                            selectedCar = car;
                            System.out.println("Selected car: " + car);                            
                        }
                    }
                    selectedTrain.addCar(selectedCar);
                    selectedTrain.trainsetInfo();
                    break;
                    
                case 5:
                    System.out.println("\nGoodbye!");
                    return;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        } while (choice != 5);
    }
}

