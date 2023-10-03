package java_pro_homeworks.pr9;

import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr9.models.Student;
import java_pro_homeworks.pr9.services.GetRandomStudentConverter;
import java_pro_homeworks.pr9.services.UseAllConvertersAndPrinters;

public class Main {

    /*
    ������� ��������� IStudentStringConverter, ���������� 1 ����� convert, ����������� Student � ������������ String.

    ������� ���������� ����� ���������� � ��� ������, ������� ���������������
    ������ � ������, ��������� StringBuilder:
    - JSON
    - XML
    - ������������� ������� ����� ���� ���������=��������

    ������� ��������� IStudentPrinter, ���������� 1 ����� print, ������� ��������� Student � ������ �� ����������.
    ������� ���������� ����� ����������, �������:
    - �������� ��������� IStudentStringConverter ����� ����������� � ���������� ���
      ��� �������������� �������� � ������ � ������.
    - ���������� ����� �������������� ������ ������� ��:
    = �� ������� ��������� System.out
    = ������ (�����-��������)
    = ���������� � ������ ���������� IStudentPrinter

    ������� ���������� ����������� ������� � ������������������ �� ������.
    */

    public static void main(String[] args) {
        Student student = new Student(21,"Den",4,true,122);

        System.out.println("==========Random==========");
        IStudentStringConverter randomConverter = new GetRandomStudentConverter().getRandomOne();
        System.out.println(randomConverter.convert(student));

        System.out.println("==========All==========");
        UseAllConvertersAndPrinters allInOnePrinter = new UseAllConvertersAndPrinters();
        allInOnePrinter.printStudentUsingAllConvertersAndPrinters(student);

    }
}
