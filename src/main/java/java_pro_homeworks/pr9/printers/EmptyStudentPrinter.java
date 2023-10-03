package java_pro_homeworks.pr9.printers;

import java_pro_homeworks.pr9.interfaces.IStudentPrinter;
import java_pro_homeworks.pr9.models.Student;

public class EmptyStudentPrinter implements IStudentPrinter {

    @Override
    public void print(Student student) {
        //Empty
    }
}
