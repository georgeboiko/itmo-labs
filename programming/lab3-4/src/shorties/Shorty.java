package shorties;
import enums.SubjectName;
import objects.Subject;
import java.util.ArrayList;
import java.util.Objects;

abstract public class Shorty {
    protected String name = "";
    protected double lazinessCoefficient, iqCoefficient;
    protected ArrayList<SubjectName> studiedSubjects = new ArrayList<SubjectName>();

    public Shorty(double lazinessCoefficient, double iqCoefficient){
        this.lazinessCoefficient = lazinessCoefficient;
        this.iqCoefficient = iqCoefficient;
    }

    public double getLazinessCoefficient(){
        return this.lazinessCoefficient;
    }
    public void setLazinessCoefficient(double coefficient){
        this.lazinessCoefficient = coefficient;
    }

    public double getIqCoefficient(){
        return this.iqCoefficient;
    }
    public void setIqCoefficient(double coefficient){
        this.iqCoefficient = coefficient;
    }

    abstract public double calcResultyCoefficient();

    public void addStudiedSubject(SubjectName subject){
        this.studiedSubjects.add(subject);
    }
    public ArrayList<SubjectName> getStudiedSubjects(){
        return this.studiedSubjects;
    }
    public void setStudiedSubjects(ArrayList<SubjectName> subjects){
        this.studiedSubjects = subjects;
    }

    public boolean tryToLearn(Subject subject){
        return this.calcResultyCoefficient() > subject.difficultyCoefficient();
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.lazinessCoefficient, this.iqCoefficient, this.studiedSubjects);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Shorty shorty = (Shorty) obj;
        return (shorty.iqCoefficient == this.iqCoefficient && shorty.lazinessCoefficient == this.lazinessCoefficient && shorty.studiedSubjects.equals(this.studiedSubjects));
    }
    @Override
    public String toString() {
        return "{lazinessCoefficient: " + this.lazinessCoefficient + ", iqCoefficient: " + this.iqCoefficient + ", studiedSubjects: " + this.studiedSubjects.toString() + "}";
    }
}