package exceptions;

public class CoefficientOverflowException extends Exception{
    public CoefficientOverflowException(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return "Значение коэффициента выходит за допустимые границы";
    }
}
