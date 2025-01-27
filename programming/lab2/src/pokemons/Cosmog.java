package pokemons;
import attacks.Facade;
import attacks.Moonblast;
import attacks.Swagger;
import attacks.WaterPulse;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Cosmog extends Pokemon{
    public Cosmog(String name, int level){
        super(name, level);
        addType(Type.PSYCHIC);
        setStats(43, 29, 31, 29, 31, 37);
        setMove(new Moonblast(), new Facade(), new Swagger(), new WaterPulse());
    }
}