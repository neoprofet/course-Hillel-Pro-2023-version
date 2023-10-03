package java_pro_homeworks.pr9.converters;

import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr9.models.Student;

public class StudentXmlConverter implements IStudentStringConverter {
    @Override
    public String convert(Student student) {
        return  "\n<student>"+
                "\n <name>"+ student.getName()+"</name>"+
                "\n <age>"+ student.getAge()+"</age>"+
                "\n <course>"+ student.getCourse()+"</course>"+
                "\n <isBudget>"+ student.isBudget()+"</isBudget>"+
                "\n <speciality>"+ student.getSpecialityCode()+"</speciality>"+
                "\n</student>";
    }
}
