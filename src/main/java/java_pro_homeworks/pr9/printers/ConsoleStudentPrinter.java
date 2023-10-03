package java_pro_homeworks.pr9.printers;

import java_pro_homeworks.pr9.interfaces.IStudentPrinter;
import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr9.models.Student;

public class ConsoleStudentPrinter implements IStudentPrinter {
    IStudentStringConverter converter;

    public ConsoleStudentPrinter(IStudentStringConverter converter) {
        this.converter = converter;
    }

    @Override
    public void print(Student student) {
        System.out.println(converter.convert(student));
    }
}
