/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.functions;

import gui_railway_project.Trainset;
import java.util.Comparator;


public class TrainsetComparator implements Comparator<Trainset> {
    public int compare(Trainset t1, Trainset t2) {
        // Sort trainsets based on route length in descending order
        if (t1.getRouteDistance() > t2.getRouteDistance()) {
            return -1;
        } else if (t1.getRouteDistance() < t2.getRouteDistance()) {
            return 1;
        } else {
            return 0;
        }
    }
}
