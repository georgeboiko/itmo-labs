package attacks;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class WaterPulse extends SpecialMove {
    public WaterPulse(){
        super(Type.WATER, 60, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Water Pulse";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 2.0/10.0) Effect.confuse(p);
    }
}