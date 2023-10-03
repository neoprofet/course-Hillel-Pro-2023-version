package java_pro_homeworks.pr10.observers;

import java_pro_homeworks.pr10.IHumanObserver;

import java.time.LocalDateTime;

public class Father implements IHumanObserver {
    private final String observerName = "Папа";

    @Override
    public void onBirth(LocalDateTime time, double height, double weight, boolean isMale, String location) {
        if(isMale) System.out.println(observerName+ ": Ура, мальчик. Будет помогать мне");
        else System.out.println(observerName+ ": Хотя бы девочка. Будет мамина помощница.");
    }

    @Override
    public void onStartGoingKindergarten(int age, String kindergartenName) {
        if(kindergartenName.equals("Sun")) System.out.println(observerName+ ": Теперь учится в моем садике");
        else if (kindergartenName.equals("Rose")) System.out.println(observerName+ ": Теперь учится в садике," +
                " где работала моя сестра");
        else System.out.println(observerName+ ": Я не в восторге от садика");
    }

    @Override
    public void onStartGoingSchool(String schoolClassLetter) {
        if(schoolClassLetter.equals("А")) System.out.println(observerName+ ": Класс лидеров");
        else System.out.println(observerName+ ": Класс неудачников, надо перевести его в А");
    }

    @Override
    public void onStartGoingUniversity(int speciality, boolean isBudget) {
        if(isBudget) System.out.println(observerName+ ": Какой умничка, ребенок на бюджете. Пусть сосед подавится от зависти.");
        else System.out.println(observerName+ ": Жаль, но поступил хотя бы, в отличии от внучки соседа и то хорошо");
    }

    @Override
    public void onGetMarried(int age, boolean isSameSexMarriage, String nameOfLover) {
        if(isSameSexMarriage) System.out.println(observerName+ ": Гомосексуальная ориентация???!!! Ну что уж, выбор за ним");
        else System.out.println(observerName+ ": Мой второй день рождения");

        if(age<20) System.out.println(observerName+ ": Свадьба почти в таком же возрасте, как и у меня");
        else System.out.println(observerName+ ": Долго судьба искалась");
    }

    @Override
    public void onHaveABaby(boolean isAdoptive, boolean isBabyMale) {
      System.out.println(observerName+ ": Воспитывай хорошо");

      if(isBabyMale) System.out.println(observerName+ ": У меня внук!!!!");
      else System.out.println(observerName+ ": У меня внучка!!!!");
    }

    @Override
    public void onDye(int age) {
      if(age<55)  System.out.println(observerName+ ": Какое горе... Так рано");
      else System.out.println(observerName+ ": Какое горе... Прожил долгую и счастливую жизнь." +
              " Было всего " + age);
    }

}
