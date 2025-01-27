package buildables;
import shorties.Shorty;
import java.util.ArrayList;
import java.util.Objects;

public class Phone implements Buildable{
    private boolean isAble = false;

    @Override
    public boolean canBuild(ArrayList<Shorty> shorties, double parameter){
        double mean = 0;
        for (var i : shorties) mean += i.calcResultyCoefficient();
        mean /= (double) shorties.size();
        if (mean > parameter + Math.random()*0.1){
            System.out.println("Коротышкам удалось провести связь в свой город!!");
            isAble = true;
            return true;
        }
        System.out.println("Коротышки не смогли провести связь :(");
        return false;
    }

    public boolean tryToCall(Shorty sourceOfCall, Shorty targetOfCall){
        if (!isAble){
            System.out.println(sourceOfCall.getName() + " не смог позвонить " + targetOfCall.getName() + ", так как нет телефонной связи!!");
            return false;
        }
        if (Math.random() > 0.1){
            System.out.println(sourceOfCall.getName() + " дозвонился до " + targetOfCall.getName() + " и обсудил интересующие его вопросы");
            return true;
        }
        System.out.println("К сожалению, телефонная связь оборвалась, так же, как и связь между " + sourceOfCall.getName() + " и " + targetOfCall.getName());
        return false;
    }

    public boolean isAble() {
        return this.isAble;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.isAble);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Phone phone = (Phone) obj;
        return (phone.isAble == this.isAble);
    }
    @Override
    public String toString() {
        return "{isAble: " + this.isAble + "}";
    }
}
