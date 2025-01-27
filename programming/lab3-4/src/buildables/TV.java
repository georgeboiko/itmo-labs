package buildables;
import enums.TVShow;
import shorties.Shorty;
import java.util.ArrayList;
import java.util.Objects;

public class TV implements Buildable{
    private boolean isAble = false;

    @Override
    public boolean canBuild(ArrayList<Shorty> shorties, double parameter){
        if (parameter == 0){
            System.out.println("Знайка не захотел помогать коротышкам в конструировании телевизора...");
            return false;
        }
        double mean = 0;
        for (var i : shorties) mean += i.calcResultyCoefficient();
        mean /= (double) shorties.size();
        if (mean > Math.random()*0.6){
            System.out.println("Коротышкам при помощи знайки удалось сконструировать телевизор!!");
            isAble = true;
            return true;
        }
        System.out.println("Коротышки не смогли сконструировать телевизор, и даже Знайке не удалось помочь им :(");
        return false;
    }

    public boolean isAble() {
        return this.isAble;
    }

    public void watch(TVShow show){
        if (!this.isAble){
            System.out.println("Коротышки хотели насладиться искусством, но, к сожалению, телевизор не сконструирован :(");
            return;
        }
        System.out.println("Пришло время наслаждаться программой " + show + "!");
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.isAble);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        TV tv = (TV) obj;
        return (tv.isAble == this.isAble);
    }
    @Override
    public String toString() {
        return "{isAble: " + this.isAble + "}";
    }
}
