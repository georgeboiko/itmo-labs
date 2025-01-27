package buildables;
import shorties.Shorty;
import java.util.ArrayList;
import java.util.Objects;

public class Lighting implements Buildable{
    private double intensity;

    public Lighting(){
        this.intensity = 0;
    }
    public Lighting(double intensity){
        this.intensity = intensity;
    }

    public double getIntensity() {
        return this.intensity;
    }
    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    @Override
    public boolean canBuild(ArrayList<Shorty> shorties, double parameter){
        double mean = 0;
        for (var i : shorties) mean += i.calcResultyCoefficient();
        mean /= (double) shorties.size();
        return (mean > parameter - Math.random()*0.15);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.intensity);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Lighting lighting = (Lighting) obj;
        return (lighting.intensity == this.intensity);
    }
    @Override
    public String toString() {
        return "{intensity: " + this.intensity + "}";
    }
}
