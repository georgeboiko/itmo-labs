package attacks;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Slash extends PhysicalMove {
    public Slash(){
        super(Type.NORMAL, 70, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Slash";
    }
    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def){
        if (3 * att.getStat(Stat.SPEED) / 512.0 > Math.random()) return 2.0;
        return 1.0;
    }
}