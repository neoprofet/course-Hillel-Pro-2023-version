package java_pro_homeworks.pr28;

public class StudentData {

   private static final String[] personNames = {"Vasily", "Ludmila", "Pavel", "Ihor",
            "Katya", "Artem", "Nick", "Andrew",
            "Ilya", "Ann", "Alexander", "Vitaliy",
            "Valentin", "Maria", "Irina", "Darina"};

   private static final String[] personSurnames = {"Kobilnik", "Vasilchuk", "Bondarenko", "Mus",
            "Novodran", "Debkaluk", "Snitko", "Gorbenko",
            "Sosnenko", "Makienko", "Stetsenko", "Sharon",
            "Boguchar", "Vanda", "Martinenko", "Matvienko"};


   static public int getRandomId() {
        return (int) (Math.random() * (30000 - 1) + 1);
    }

   static public int getRandomSpeciality() {
        return (int) (Math.random() * (200 - 1) + 1);
    }

   static public String getRandomPersonName() {
        return personNames[(int) (Math.random() * (int)Math.floor(Math.random() * personNames.length))];
    }

   static public String getRandomPersonSurname() {
        return personSurnames[(int) (Math.random() * (int)Math.floor(Math.random() * personSurnames.length))];
    }

}
