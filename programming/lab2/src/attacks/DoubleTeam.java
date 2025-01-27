package attacks;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleTeam extends StatusMove {
    public DoubleTeam(){
        super(Type.NORMAL, 0, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Double Team";
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        if (p.getStat(Stat.EVASION)+1 <= 6.0) p.setMod(Stat.EVASION, 1);
    }
}
