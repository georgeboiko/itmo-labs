package shorties;
import enums.SubjectName;
import objects.Subject;
import java.util.Map;
import java.util.Objects;

public class Neznayka extends Shorty {
    public Neznayka(double lazinessCoefficient, double iqCoefficient){
        super(lazinessCoefficient, iqCoefficient);
        this.name = "Незнайка";
    }

    @Override
    public double calcResultyCoefficient() {
        return iqCoefficient * (1.0 - lazinessCoefficient);
    }

    public void goOnVacation(){
        double iqBoost = Math.random()*0.4;
        double lazinessBoost = Math.random()*0.3;
        this.setIqCoefficient(this.getIqCoefficient() + iqBoost);
        this.setLazinessCoefficient(this.getLazinessCoefficient() - lazinessBoost);
        String output = String.format("Незнайка съездил в отпуск! Теперь коеффициент его интеллекта увеличился на %f, а лени - уменьшился на %f!", iqBoost, lazinessBoost);
        System.out.println(output);
    }

    private boolean learnSubject(Map<SubjectName, Subject> subjects, SubjectName name, String message){
        boolean canLearn = this.tryToLearn(subjects.get(name));
        if (!canLearn){
            System.out.println(message);
            return true;
        }
        this.addStudiedSubject(name);
        return false;
    }

    public void study(Map<SubjectName, Subject> subjects){
        if (learnSubject(subjects, SubjectName.READING, "Незнайке не хватило ума даже чтобы научиться читать!!")) return;
        if (learnSubject(subjects, SubjectName.WRITING, "В силу своих способностей Незнайка смог научиться только читать, а письмо не осилил :(")) return;
        if (learnSubject(subjects, SubjectName.GRAMMAR, "Незнайка научился читать и даже немного писать, однако делает он это неграмотно...")) return;
        if (learnSubject(subjects, SubjectName.ARITHMETIC, "Незнайка освоил гуманитарные науки начальной школы, а также смог понять арифметику!")) return;
        if (learnSubject(subjects, SubjectName.PHYSICS, "Незнайка превзошел самого себя, не только изучив чтение, письмо, грамматику и арифметику, но и открыл для себя физику!!!")) return;
    }
}