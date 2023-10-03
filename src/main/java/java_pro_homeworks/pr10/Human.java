package java_pro_homeworks.pr10;

import java_pro_homeworks.pr10.data.HumanData;
import java_pro_homeworks.pr10.handlers.RandomFromArray;

import java.time.LocalDateTime;
import java.util.Random;

public class Human {
    private IHumanObserver[] observers;

    /**
     * Поля используются в методах, так что вынесены вне события
     */
    private boolean isMale;
    private boolean isSameSexMarriage;

    /**
     * Событие: родился
     */
    public void doStartLife() {
        LocalDateTime time = LocalDateTime.now();
        String location = RandomFromArray.getRandomStringFromArray(HumanData.getLocations());
        double height = Math.random() * (90 - 50) + 50;
        double weight = Math.random() * (4.0 - 1.8) + 1.8;
        isMale = new Random().nextBoolean();

        for (IHumanObserver observer : observers) {
            observer.onBirth(time, height, weight, isMale, location);
        }
    }

    /**
     * Событие: пошел в детский садик
     */
    public void doStartGoingKindergarten() {
        int age = (int) (Math.random() * (1 - 4) + 1);
        String kindergartenName = RandomFromArray.getRandomStringFromArray(HumanData.getKindergartenNames());

        for (IHumanObserver observer : observers) {
            observer.onStartGoingKindergarten(age, kindergartenName);
        }
    }

    /**
     * Событие: пошел в школу
     */
    public void doStartGoingSchool() {
        String schoolClassLetter = RandomFromArray.getRandomStringFromArray(HumanData.getSchoolClassLetters());
        for (IHumanObserver observer : observers) {
            observer.onStartGoingSchool(schoolClassLetter);
        }
    }

    /**
     * Событие: поступил в университет
     */
    public void doStartGoingUniversity() {
        int speciality = (int) (Math.random() * (1 - 180) + 1);
        boolean isBudget = new Random().nextBoolean();

        for (IHumanObserver observer : observers) {
            observer.onStartGoingUniversity(speciality, isBudget);
        }
    }

    /**
     * Событие: поженился
     */
    public void doGetMarried() {
        int age = (int) (Math.random() * (18 - 40) + 18);
        isSameSexMarriage = new Random().nextBoolean();
        String nameOfLover;
        if ((isSameSexMarriage && isMale) || (!isSameSexMarriage && !isMale)) {
            nameOfLover = RandomFromArray.getRandomStringFromArray(HumanData.getMaleNames());
        } else nameOfLover = RandomFromArray.getRandomStringFromArray(HumanData.getFemaleNames());

        for (IHumanObserver observer : observers) {
            observer.onGetMarried(age, isSameSexMarriage, nameOfLover);
        }
    }

    /**
     * Событие: завел ребенка
     * Если однополый брак -> ребенок приемный
     */
    public void doHaveABaby() {
        for (IHumanObserver observer : observers) {
            observer.onHaveABaby(isSameSexMarriage, new Random().nextBoolean());
        }
    }

    /**
     * Событие: умер
     */
    public void doDie() {
        for (IHumanObserver observer : observers) {
            observer.onDye((int) (Math.random() * (42 - 70) + 42));
        }

    }

    public void runAllLifecycles(){
        System.out.println("******************* СОБЫТИЕ: РОЖДЕНИЕ *******************");
        doStartLife();
        System.out.println("************** СОБЫТИЕ: НАЧАЛ ХОДИТЬ В САД ***************");
        doStartGoingKindergarten();
        System.out.println("************ СОБЫТИЕ: НАЧАЛ ХОДИТЬ В ШКОЛУ ***************");
        doStartGoingSchool();
        System.out.println("************** СОБЫТИЕ: НАЧАЛ ХОДИТЬ В ВУЗ ***************");
        doStartGoingUniversity();
        System.out.println("******************* СОБЫТИЕ: ПОЖЕНИЛСЯ *******************");
        doGetMarried();
        System.out.println("**************** СОБЫТИЕ: ЗАВЕЛ РЕБЕНКА ******************");
        doHaveABaby();
        System.out.println("******************** СОБЫТИЕ: ПОГИБ **********************");
        doDie();
    }

    public void setObserver(IHumanObserver[] observers) {
        this.observers = observers;
    }

    public IHumanObserver[] getObservers() {
        return observers;
    }
}
