package java_pro_homeworks.pr9.converters;

import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr9.models.Student;

public class StudentKeyValueConverter implements IStudentStringConverter {
    @Override
    public String convert(Student student) {
        return "name= "+ student.getName()+
                "\nage= "+ student.getAge()+
                "\ncourse= "+ student.getCourse()+
                "\nisBudget= "+ student.isBudget()+
                "\nspeciality= "+ student.getSpecialityCode();
    }
}
