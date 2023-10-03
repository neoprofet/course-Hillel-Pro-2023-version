package java_pro_homeworks.pr10.observers;

import java_pro_homeworks.pr10.IHumanObserver;

import java.time.LocalDateTime;

public class Father implements IHumanObserver {
    private final String observerName = "����";

    @Override
    public void onBirth(LocalDateTime time, double height, double weight, boolean isMale, String location) {
        if(isMale) System.out.println(observerName+ ": ���, �������. ����� �������� ���");
        else System.out.println(observerName+ ": ���� �� �������. ����� ������ ���������.");
    }

    @Override
    public void onStartGoingKindergarten(int age, String kindergartenName) {
        if(kindergartenName.equals("Sun")) System.out.println(observerName+ ": ������ ������ � ���� ������");
        else if (kindergartenName.equals("Rose")) System.out.println(observerName+ ": ������ ������ � ������," +
                " ��� �������� ��� ������");
        else System.out.println(observerName+ ": � �� � �������� �� ������");
    }

    @Override
    public void onStartGoingSchool(String schoolClassLetter) {
        if(schoolClassLetter.equals("�")) System.out.println(observerName+ ": ����� �������");
        else System.out.println(observerName+ ": ����� �����������, ���� ��������� ��� � �");
    }

    @Override
    public void onStartGoingUniversity(int speciality, boolean isBudget) {
        if(isBudget) System.out.println(observerName+ ": ����� �������, ������� �� �������. ����� ����� ��������� �� �������.");
        else System.out.println(observerName+ ": ����, �� �������� ���� ��, � ������� �� ������ ������ � �� ������");
    }

    @Override
    public void onGetMarried(int age, boolean isSameSexMarriage, String nameOfLover) {
        if(isSameSexMarriage) System.out.println(observerName+ ": ��������������� ����������???!!! �� ��� ��, ����� �� ���");
        else System.out.println(observerName+ ": ��� ������ ���� ��������");

        if(age<20) System.out.println(observerName+ ": ������� ����� � ����� �� ��������, ��� � � ����");
        else System.out.println(observerName+ ": ����� ������ ��������");
    }

    @Override
    public void onHaveABaby(boolean isAdoptive, boolean isBabyMale) {
      System.out.println(observerName+ ": ���������� ������");

      if(isBabyMale) System.out.println(observerName+ ": � ���� ����!!!!");
      else System.out.println(observerName+ ": � ���� ������!!!!");
    }

    @Override
    public void onDye(int age) {
      if(age<55)  System.out.println(observerName+ ": ����� ����... ��� ����");
      else System.out.println(observerName+ ": ����� ����... ������ ������ � ���������� �����." +
              " ���� ����� " + age);
    }

}
