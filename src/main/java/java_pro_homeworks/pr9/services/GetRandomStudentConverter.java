package java_pro_homeworks.pr9.services;

import java_pro_homeworks.pr9.converters.StudentJsonConverter;
import java_pro_homeworks.pr9.converters.StudentKeyValueConverter;
import java_pro_homeworks.pr9.converters.StudentXmlConverter;
import java_pro_homeworks.pr9.interfaces.IStudentStringConverter;

public class GetRandomStudentConverter {
    public IStudentStringConverter getRandomOne(){
        double randomValue = Math.random();
        if(randomValue<0.3) return new StudentXmlConverter();
        else if (randomValue>0.3 && randomValue<0.6) return new StudentJsonConverter();
        else return new StudentKeyValueConverter();
    }
}
