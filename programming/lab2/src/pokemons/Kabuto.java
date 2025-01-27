package pokemons;
import attacks.AerialAce;
import attacks.AquaJet;
import attacks.Leer;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Kabuto extends Pokemon {
    public Kabuto(String name, int level){
        super(name, level);
        addType(Type.ROCK);
        addType(Type.WATER);
        setStats(30, 80, 90, 55, 45, 55);
        setMove(new AerialAce(),  new AquaJet(), new Leer());
    }
}