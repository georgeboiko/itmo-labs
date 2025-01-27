package shorties;

public class OtherShorty extends Shorty{
    public OtherShorty(){
        super(Math.random()*0.3, Math.random()*0.6);
    }
    @Override
    public double calcResultyCoefficient() {
        return iqCoefficient * (1.0 - lazinessCoefficient);
    }
}