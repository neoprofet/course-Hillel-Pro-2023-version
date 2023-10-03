package java_pro_homeworks.pr11.observer.data;

public class HumanData {
    private static final String[] maleNames = {
          "����", "������", "�����", "�������", "�����", "�����", "�������", "�����"
    };

    private static final String[] femaleNames = {
            "�����", "����", "�����", "�������", "�������", "������", "��������", "���������"
    };

    private static final String[] kindergartenNames = {
            "Sun", "Rose", "Semitone", "Wind", "Mushroom", "Marine wave", "Nemo", "Nirvana"
    };

    private static final String[] schoolClassLetters = {
            "�", "�", "�", "�", "�"
    };


    private static final String[] locations = {
            "�������", "����", "����������"
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
