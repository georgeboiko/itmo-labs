package objects;
import buildables.Lighting;
import shorties.Shorty;
import java.util.ArrayList;
import java.util.Objects;

public class Street {
    protected String name;
    protected double length;
    protected double trafficCoefficient;
    protected Lighting lighting;

    public Street(String name, double length){
        this.name = name;
        this.length = length;
        this.trafficCoefficient = Math.random();
        this.lighting = new Lighting();
    }
    public Street(String name, double length, double trafficCoefficient){
        this.name = name;
        this.length = length;
        this.trafficCoefficient = trafficCoefficient;
        this.lighting = new Lighting();
    }

    public String getName(){
        return this.name;
    }

    public double getTrafficCoefficient() {
        return this.trafficCoefficient;
    }
    public void setTrafficCoefficient(double trafficCoefficient) {
        this.trafficCoefficient = trafficCoefficient;
    }

    public void tryToMakeLighting(ArrayList<Shorty> shorties){
        try {
            if (this.lighting.canBuild(shorties, this.length * this.trafficCoefficient)) {
                this.lighting.setIntensity(0.85 + Math.random() * 0.15);
                System.out.println("Коротышкам удалось установить освещение на улице " + this.name + " с коеффициентом яркости " + this.lighting.getIntensity() + "!");
            } else System.out.println("Коротышки не справились с установкой освещения на улице " + this.name + "...");
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.length, this.trafficCoefficient, this.lighting);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Street street = (Street) obj;
        return (street.name == this.name && street.length == this.length && street.trafficCoefficient == this.trafficCoefficient && this.lighting.equals(street.lighting));
    }
    @Override
    public String toString() {
        return "{name: " + this.name + ", length: " + this.length + ", trafficCoefficient: " + this.trafficCoefficient + ", lighting: " + this.lighting.toString() + "}";
    }
}
