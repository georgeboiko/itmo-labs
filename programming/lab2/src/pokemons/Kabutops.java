package pokemons;
import attacks.AerialAce;
import attacks.AquaJet;
import attacks.Leer;
import attacks.Slash;
import ru.ifmo.se.pokemon.Type;

public class Kabutops extends Kabuto {
    public Kabutops(String name, int level){
        super(name, level);
        setStats(60, 115, 105, 65, 70, 80);
        addMove(new Slash());
    }
}