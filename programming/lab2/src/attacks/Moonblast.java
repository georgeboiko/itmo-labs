package attacks;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Moonblast extends SpecialMove {
    public Moonblast(){
        super(Type.FAIRY, 95, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Moonblast";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() < 3.0/10.0) p.setMod(Stat.SPECIAL_ATTACK, -1);
    }
}