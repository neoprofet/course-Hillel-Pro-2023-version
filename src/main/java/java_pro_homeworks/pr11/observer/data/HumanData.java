package java_pro_homeworks.pr11.observer.data;

public class HumanData {
    private static final String[] maleNames = {
          "Илья", "Никита", "Денис", "Виталий", "Антон", "Павел", "Дмитрий", "Игорь"
    };

    private static final String[] femaleNames = {
            "Мария", "Анна", "Дария", "Людмила", "Эльвира", "Лариса", "Катерина", "Валентина"
    };

    private static final String[] kindergartenNames = {
            "Sun", "Rose", "Semitone", "Wind", "Mushroom", "Marine wave", "Nemo", "Nirvana"
    };

    private static final String[] schoolClassLetters = {
            "А", "Б", "В", "Г", "Д"
    };


    private static final String[] locations = {
            "Харьков", "Киев", "Кировоград"
    };



    //Getters

    public static String[] getMaleNames() {
        return maleNames;
    }

    public static String[] getFemaleNames() {
        return femaleNames;
    }

    public static String[] getLocations() {
        return locations;
    }

    public static String[] getKindergartenNames(){
        return kindergartenNames;
    }

    public static String[] getSchoolClassLetters(){
        return schoolClassLetters;
    }


}
