package java_pro_homeworks.pr9;

import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr9.models.Student;
import java_pro_homeworks.pr9.services.GetRandomStudentConverter;
import java_pro_homeworks.pr9.services.UseAllConvertersAndPrinters;

public class Main {

    /*
    Создать интерфейс IStudentStringConverter, содержащий 1 метод convert, принимающий Student и возвращающий String.

    Создать реализации этого интерфейса и его метода, которые преобразовывают
    объект в строку, используя StringBuilder:
    - JSON
    - XML
    - Многострочный простой текст вида “параметр=значение”

    Создать интерфейс IStudentPrinter, содержащий 1 метод print, который принимает Student и ничего не возвращает.
    Создать реализации этого интерфейса, которые:
    - Получают экземпляр IStudentStringConverter через конструктор и используют его
      для преобразования студента в строку в методе.
    - Полученную после преобразования строку выводят ее:
    = На консоль используя System.out
    = Никуда (класс-пустышка)
    = Делегируют в другие экземпляры IStudentPrinter

    Создать экземпляры объявленных классов и продемонстрировать их работу.
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
