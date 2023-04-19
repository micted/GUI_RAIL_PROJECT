/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_railway_project.Exception;

/**
 *
 * @author Hp
 */


public class RailroadHazard extends Exception{
    public RailroadHazard()
    {
        super("WARNING !! Train speed exceeds 200km/h");
    }
}

