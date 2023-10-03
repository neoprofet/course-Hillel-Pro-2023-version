package java_pro_homeworks.pr11.observer;

import java.time.LocalDateTime;

public interface IHumanObserver {
    void onBirth(BirthParams params);

    void onStartGoingKindergarten(StartGoingKindergartenParams params);

    void onStartGoingSchool(StartGoingSchoolParams params);

    void onStartGoingUniversity(StartGoingUniversityParams params);

    void onGetMarried(GetMarriedParams params);

    void onHaveABaby(HaveABabyParams params);

    void onDye(DyeParams params);


    static class BirthParams {
        public LocalDateTime time;
        public double height;
        public double weight;
        public boolean isMale;
        public  String location;

        public BirthParams(LocalDateTime time, double height, double weight, boolean isMale, String location) {
            this.time = time;
            this.height = height;
            this.weight = weight;
            this.isMale = isMale;
            this.location = location;
        }
    }

    static class StartGoingKindergartenParams {
        public  int age;
        public String kindergartenName;

        public StartGoingKindergartenParams(int age, String kindergartenName) {
            this.age = age;
            this.kindergartenName = kindergartenName;
        }
    }

    static class StartGoingSchoolParams {
        public String schoolClassLetter;

        public StartGoingSchoolParams(String schoolClassLetter) {
            this.schoolClassLetter = schoolClassLetter;
        }
    }

    static class StartGoingUniversityParams {
        public int speciality;
        public boolean isBudget;

        public StartGoingUniversityParams(int speciality, boolean isBudget) {
            this.speciality = speciality;
            this.isBudget = isBudget;
        }
    }

    static class GetMarriedParams {
        public int age;
        public boolean isSameSexMarriage;
        public String nameOfLover;

        public GetMarriedParams(int age, boolean isSameSexMarriage, String nameOfLover) {
            this.age = age;
            this.isSameSexMarriage = isSameSexMarriage;
            this.nameOfLover = nameOfLover;
        }
    }

    static class HaveABabyParams {
        public boolean isAdoptive;
        public boolean isBabyMale;

        public HaveABabyParams(boolean isAdoptive, boolean isBabyMale) {
            this.isAdoptive = isAdoptive;
            this.isBabyMale = isBabyMale;
        }
    }

    static class DyeParams{
        public int age;

        public DyeParams(int age) {
            this.age = age;
        }
    }


}


