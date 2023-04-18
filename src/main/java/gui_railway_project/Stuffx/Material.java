package gui_railway_project.Stuffx;

import gui_railway_project.Stuff.Stuff;

public class Material extends Stuff{
    private Materials material;

    public Material(double weight, Materials material) {
        super(weight);
        this.material = material;
    }

    public Materials getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Material{" +
                "material=" + material +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Material material = new Material(111, Materials.gaseousMaterial);
        System.out.println(material);
    }
}
