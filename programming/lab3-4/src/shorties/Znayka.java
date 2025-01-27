package shorties;
import enums.SubjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Znayka extends Shorty{
    protected double kindnessCoefficient;

    public Znayka(double lazinessCoefficient, double iqCoefficient, double kindnessCoefficient){
        super(lazinessCoefficient, iqCoefficient);
        this.studiedSubjects = new ArrayList<SubjectName>(List.of(SubjectName.READING, SubjectName.WRITING, SubjectName.GRAMMAR, SubjectName.ARITHMETIC, SubjectName.PHYSICS));
        this.kindnessCoefficient = kindnessCoefficient;
        this.name = "Знайка";
    }

    @Override
    public double calcResultyCoefficient() {
        return iqCoefficient * (1.0 - lazinessCoefficient);
    }

    public void setKindnessCoefficient(double coefficient){
        this.kindnessCoefficient = coefficient;
    }
    public double getKindnessCoefficient(){
        return this.kindnessCoefficient;
    }

    public boolean isReadyToHelpSomebody(){
        return this.kindnessCoefficient > Math.random();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.lazinessCoefficient, this.iqCoefficient, this.studiedSubjects, this.kindnessCoefficient);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Znayka znayka = (Znayka) obj;
        return (znayka.iqCoefficient == this.iqCoefficient && znayka.lazinessCoefficient == this.lazinessCoefficient && znayka.studiedSubjects.equals(this.studiedSubjects) && znayka.kindnessCoefficient == this.kindnessCoefficient);
    }
    @Override
    public String toString() {
        return "{lazinessCoefficient: " + this.lazinessCoefficient + ", iqCoefficient: " + this.iqCoefficient + ", studiedSubjects: " + this.studiedSubjects.toString() + ", kindnessCoefficient: " + this.kindnessCoefficient + "}";
    }
}