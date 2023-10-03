package java_pro_homeworks.pr9.converters;

import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr9.models.Student;

public class StudentJsonConverter implements IStudentStringConverter {

    @Override
    public String convert(Student student) {
        return "{" +
                "\"name\": "+ student.getName()+
                "\n\"age\": "+ student.getAge()+
                "\n\"course\": "+ student.getCourse()+
                "\n\"isBudget\": "+ student.isBudget()+
                "\n\"speciality\": "+ student.getSpecialityCode()+
                "\n }";
    }
}
