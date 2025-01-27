import pokemons.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Cosmog("Сигма", 1);
        Pokemon p2 = new Kabuto("Бизнесмен", 1);
        Pokemon p3 = new Kabutops("Альфа", 1);
        Pokemon p4 = new Nuzleaf("Билли", 1);
        Pokemon p5 = new Seedot("Нормис", 1);
        Pokemon p6 = new Shiftry("Арни", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
