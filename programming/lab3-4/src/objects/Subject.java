package objects;
import enums.SubjectName;
import java.util.Objects;

public record Subject(SubjectName name, double difficultyCoefficient) {
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.difficultyCoefficient);
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Subject subject = (Subject) obj;
        return (subject.name == this.name && subject.difficultyCoefficient == this.difficultyCoefficient);
    }
    @Override
    public String toString() {
        return "{name: " + this.name + ", difficultyCoefficient: " + this.difficultyCoefficient + "}";
    }
}
