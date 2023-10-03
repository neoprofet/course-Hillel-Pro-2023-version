package java_pro_homeworks.pr9.services;

import java_pro_homeworks.pr9.converters.StudentJsonConverter;
import java_pro_homeworks.pr9.converters.StudentKeyValueConverter;
import java_pro_homeworks.pr9.converters.StudentXmlConverter;
import java_pro_homeworks.pr9.interfaces.IStudentPrinter;
import java_pro_homeworks.pr9.models.Student;
import java_pro_homeworks.pr9.printers.ConsoleStudentPrinter;
import java_pro_homeworks.pr9.printers.DelegatingStudentPrinter;
import java_pro_homeworks.pr9.printers.EmptyStudentPrinter;

public class UseAllConvertersAndPrinters {

    public void printStudentUsingAllConvertersAndPrinters(Student student) {

        IStudentPrinter[] printers = new IStudentPrinter[]{
                new ConsoleStudentPrinter(new StudentJsonConverter()),
                new ConsoleStudentPrinter(new StudentXmlConverter()),
                new ConsoleStudentPrinter(new StudentKeyValueConverter()),
                new EmptyStudentPrinter()};

        DelegatingStudentPrinter printer = new DelegatingStudentPrinter(printers);
        printer.print(student);

    }



}



