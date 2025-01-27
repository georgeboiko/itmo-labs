package attacks;
import ru.ifmo.se.pokemon.*;

public class Leer extends StatusMove {
    public Leer(){
        super(Type.NORMAL, 0, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Leer";
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if (p.getStat(Stat.DEFENSE)-1 >= -6.0) p.setMod(Stat.DEFENSE, -1);
    }
}
