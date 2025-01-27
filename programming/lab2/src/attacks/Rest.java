package attacks;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Rest extends StatusMove {
    public Rest(){
        super(Type.PSYCHIC, 0, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Rest";
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        Effect.sleep(p);
    }
}
