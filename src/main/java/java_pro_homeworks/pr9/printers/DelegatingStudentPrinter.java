package java_pro_homeworks.pr9.printers;

import java_pro_homeworks.pr9.interfaces.IStudentPrinter;
import java_pro_homeworks.pr9.models.Student;

public class DelegatingStudentPrinter implements IStudentPrinter {
    IStudentPrinter[] printers;

    public DelegatingStudentPrinter(IStudentPrinter[] printers) {
        this.printers = printers;
    }

    @Override
    public void print(Student student) {
        for (IStudentPrinter printer : printers) {
            printer.print(student);
        }
    }
}
