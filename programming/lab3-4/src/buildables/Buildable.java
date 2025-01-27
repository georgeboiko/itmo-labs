package buildables;
import shorties.Shorty;
import java.util.ArrayList;

public interface Buildable {
    public boolean canBuild(ArrayList<Shorty> shorties, double parameter) throws ArithmeticException;
}