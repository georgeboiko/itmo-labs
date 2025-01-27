package attacks;
import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.PSYCHIC, 70, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Facade";
    }
    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def){
        if (att.getCondition() == Status.POISON || att.getCondition() == Status.PARALYZE) return 2*super.calcBaseDamage(att, def);
        return super.calcBaseDamage(att, def);
    }
}