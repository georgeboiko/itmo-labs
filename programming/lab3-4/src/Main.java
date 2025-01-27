import enums.*;
import exceptions.CoefficientOverflowException;
import objects.*;
import shorties.*;
import buildables.*;
import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.Math.min;

public class Main {

    public static double genRandVal(double base, double dispersion) throws CoefficientOverflowException {
        double val = base + Math.random() * dispersion;
        if (val > 1 || val < 0) throw new CoefficientOverflowException("Значение коэффициента выходит за допустимые границы");
        return val;
    }

    public static double validate(double base, double dispersion){
        try {
            return genRandVal(base, dispersion);
        } catch (CoefficientOverflowException e) {
            System.out.println(e.getMessage());
            return 0.5;
        }
    }

    public static void main(String[] args) {
        HashMap<SubjectName, Subject> subjects = new HashMap<>();
        subjects.put(SubjectName.READING, new Subject(SubjectName.READING, validate(0.15, 0.05)));
        subjects.put(SubjectName.WRITING, new Subject(SubjectName.WRITING, validate(0.2, 0.05)));
        subjects.put(SubjectName.GRAMMAR, new Subject(SubjectName.GRAMMAR, validate(0.25, 0.05)));
        subjects.put(SubjectName.ARITHMETIC, new Subject(SubjectName.ARITHMETIC, validate(0.32, 0.05)));
        subjects.put(SubjectName.PHYSICS, new Subject(SubjectName.PHYSICS, validate(0.4, 0.05)));

        City city = new City("N");
        Street s1 = new Street("a", validate(0.6, 0.05), validate(0.45, 0.1)); city.addStreet(s1);
        Street s2 = new Street("b", validate(0.4, 0.1), validate(0.3, 0.2)); city.addStreet(s2);
        Street s3 = new Street("c", validate(0.5, 0.1), validate(0.4, 0.1)); city.addStreet(s3);
        Street s4 = new Street("d", validate(0.3, 0.1), validate(0.3, 0.1)); city.addStreet(s4);
        Street s5 = new Street("e", validate(0.35, 0.1), validate(0.3, 0.15)); city.addStreet(s5);

        System.out.println("Коротышки обустраивают город " + city.getName());

        Vintik vintik = new Vintik(validate(0.3, 0.2), validate(0.55, 0.2));
        Schpuntik schpuntik = new Schpuntik(validate(0.2, 0.2), validate(0.5, 0.3));
        Znayka znayka = new Znayka(validate(0.05, 0.1), validate(0.85, 0.15), validate(0.7, 0.2));
        Neznayka neznayka = new Neznayka(validate(0.5, 0.25), validate(0.45, 0.25));

        ArrayList<Shorty> shortiesWorkers = new ArrayList<Shorty>();
        for (int i = 0; i < 5 + (int)(Math.random()*10); ++i){
            shortiesWorkers.add(new OtherShorty());
        }

        for (int i = 0; i < city.getStreets().size(); ++i){
            city.getStreets().get(i).tryToMakeLighting(shortiesWorkers);
        }

        Phone phone = new Phone();
        try {
            phone.canBuild(shortiesWorkers, 0.1);
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        TV tv = new TV();
        boolean tryCall1 = phone.tryToCall(vintik, znayka), tryCall2 = phone.tryToCall(schpuntik, znayka);
        if (tryCall1 && tryCall2){
            boolean tryStudy1 = vintik.study(subjects), tryStudy2 = schpuntik.study(subjects);
            if (tryStudy1 && tryStudy2) {
                double requestFromVintik = vintik.requestHelp(znayka) ? 1 : 0;
                double requestFromSchpuntik = schpuntik.requestHelp(znayka) ? 1 : 0;
                ArrayList<Shorty> vintikAndSchpuntik = new ArrayList<Shorty>();
                vintikAndSchpuntik.add(vintik);
                vintikAndSchpuntik.add(schpuntik);
                try {
                    tv.canBuild(vintikAndSchpuntik, min(requestFromVintik, requestFromSchpuntik));
                }
                catch (ArithmeticException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        tv.watch(TVShow.PERFOMANCE);

        System.out.println("Теперь поговорим про Незнайку!");

        neznayka.goOnVacation();
        neznayka.study(subjects);
    }
}
