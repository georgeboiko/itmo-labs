package pokemons;
import attacks.DoubleTeam;
import attacks.Extrasensory;
import attacks.Facade;
import attacks.Rest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Shiftry extends Nuzleaf {
    public Shiftry(String name, int level){
        super(name, level);
        setStats(90, 100, 60, 90, 60, 80);
        addMove(new Rest());
    }
}
