package java_pro_homeworks.pr10.observers;

import java_pro_homeworks.pr10.IHumanObserver;

import java.time.LocalDateTime;

public class Neighbour implements IHumanObserver {
    private final String observerName = "Сосед";

    @Override
    public void onBirth(LocalDateTime time, double height, double weight, boolean isMale, String location) {
        System.out.println(observerName+ ": Кошмар, теперь будет за стенкой орать.");
    }

    @Override
    public void onStartGoingKindergarten(int age, String kindergartenName) {
        System.out.println(observerName+ ": Класс, теперь ребенок-спиногрыз ходит в сад вместе с моей внучкой.");
    }

    @Override
    public void onStartGoingSchool(String schoolClassLetter) {
        System.out.println(observerName+ ": Каждый раз когда идет в школу утром, орет со своими друзьями." +
                "громче, чем собаки по утрам");
    }

    @Override
    public void onStartGoingUniversity(int speciality, boolean isBudget) {
        if(isBudget) System.out.println(observerName+ ": Только благодаря его мамашки учится на бюджете");
        else System.out.println(observerName+ ": Хорошо, что этот глупый подросток поступил хоть на контракт");
    }

    @Override
    public void onGetMarried(int age, boolean isSameSexMarriage, String nameOfLover) {
        if(isSameSexMarriage) System.out.println(observerName+ ": АХХАХАХАх. Вообще песня");
        else System.out.println(observerName+ ": Странно, что вообще пара нашлася");

        if(age<20) System.out.println(observerName+ ": На удивление рано");
        else System.out.println(observerName+ ": Не удивительно, что долго не было партнера");
    }

    @Override
    public void onHaveABaby(boolean isAdoptive, boolean isBabyMale) {
        if(isAdoptive) System.out.println(observerName+ ": Зачем вообще гробить чужие жизни и брать приемного ребенка");
        else System.out.println(observerName+ ": Зачем размножаться?");
    }

    @Override
    public void onDye(int age) {
        System.out.println(observerName+ ": Умер..., хорошо, что я дожил до этого");
    }


}
