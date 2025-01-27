package attacks;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Effect;

public class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL, 0, 85);
    }
    @Override
    protected String describe(){
        return "attacks with Swagger";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        Effect.confuse(p);
        if (p.getStat(Stat.ATTACK)+2 <= 6) p.setMod(Stat.ATTACK, 2);
    }
}