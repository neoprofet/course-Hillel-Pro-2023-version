package java_pro_homeworks.pr10;

import java.time.LocalDateTime;

public interface IHumanObserver {
     void onBirth(LocalDateTime time, double height, double weight, boolean isMale, String location);
     void onStartGoingKindergarten(int age, String kindergartenName);
     void onStartGoingSchool(String schoolClassLetter);
     void onStartGoingUniversity(int speciality, boolean isBudget);
     void onGetMarried(int age, boolean isSameSexMarriage, String nameOfLover);
     void onHaveABaby(boolean isAdoptive, boolean isBabyMale);
     void onDye(int age);
}
