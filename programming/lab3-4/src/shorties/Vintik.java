package shorties;
import enums.SubjectName;
import objects.Subject;
import java.util.Map;

public class Vintik extends Shorty{
    public Vintik(double lazinessCoefficient, double iqCoefficient){
        super(lazinessCoefficient, iqCoefficient);
        this.name = "Винтик";
    }

    @Override
    public double calcResultyCoefficient() {
        return iqCoefficient * (1.0 - lazinessCoefficient);
    }

    public boolean study(Map<SubjectName, Subject> subjects){
        if (this.tryToLearn(subjects.get(SubjectName.READING))) this.addStudiedSubject(SubjectName.READING);
        if (this.tryToLearn(subjects.get(SubjectName.ARITHMETIC))) this.addStudiedSubject(SubjectName.ARITHMETIC);
        if (this.getStudiedSubjects().size() == 2){
            System.out.println("Винтик получил знания, необходимые для конструирования телевизора, и теперь просит Знайку о помощи!");
            return true;
        }
        if (this.getStudiedSubjects().isEmpty()){
            System.out.println("Винтик настолько разленился и деградировал, что не смог научиться конструировать телевизор!!");
        }
        else if (this.getStudiedSubjects().get(0) == SubjectName.READING){
            System.out.println("Винтику не хватило знаний математики, чтобы сконструировать телевизор :(");
        }
        else if (this.getStudiedSubjects().get(0) == SubjectName.ARITHMETIC){
            System.out.println("Винтику не научился читать, поэтому он не может сконструировать телевизор :(");
        }
        return false;
    }

    public boolean requestHelp(Znayka znayka){
        if (znayka.isReadyToHelpSomebody()){
            System.out.println("Знайка готов помочь Винтику!");
            return true;
        }
        System.out.println("Знайка не хочет помогать Винтику((");
        return false;
    }
}
