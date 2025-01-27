package attacks;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Extrasensory extends PhysicalMove {
    public Extrasensory(){
        super(Type.PSYCHIC, 80, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Extrasensory";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 1.0/10.0) Effect.flinch(p);
    }
}
