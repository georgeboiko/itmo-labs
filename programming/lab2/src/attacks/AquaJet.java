package attacks;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class AquaJet extends PhysicalMove {
    public AquaJet(){
        super(Type.WATER, 40, 100);
        priority = 1;
    }
    @Override
    protected String describe(){
        return "attacks with Aqua Jet";
    }
}