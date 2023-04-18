package gui_railway_project.Stuff;

import gui_railway_project.Stuff.Human;

public class Baggage extends Stuff{
    private Human owner;

    public Baggage(double weight, Human owner) {
        super(weight);
        this.owner = owner;
    }
}
