package pokemons;
import attacks.DoubleTeam;
import attacks.Extrasensory;
import attacks.Facade;
import ru.ifmo.se.pokemon.Type;

public class Nuzleaf extends Seedot {
    public Nuzleaf(String name, int level){
        super(name, level);
        addType(Type.DARK);
        setStats(70, 70, 40, 60, 40, 60);
        addMove(new Extrasensory());
    }
}
