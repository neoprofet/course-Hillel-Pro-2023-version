package java_pro_homeworks.pr3;

public class StudentHandler {
    public  void showStudentInfo(Student student){
        System.out.println("{" +
                "Name: "+ student.getName()+
                ", age: "+ student.getAge()+
                ", course: "+ student.getCourse()+
                ", is budget: "+ student.isBudgetaryBasis()+
                "}");
    }

    public void showStudentsInfo(Student[] students){
        for (Student student : students) {
            showStudentInfo(student);
        }
    }

    public Student[] getSortedStudentsByAge(Student[] students){
        for (int i = 0; i < students.length-1; i++) {
            for (int j = students.length - 1; j > i; j--)
            if(students[j-1].getAge() > students[j].getAge()){
                Student temp = students[j-1];
                students[j-1]= students[j];
                students[j] = temp;
            }
        }
        return students;
    }

    public Student[] getSortedStudentsByName(Student[] students){
        for (int i = 0; i < students.length-1; i++) {
            for (int j = students.length - 1; j > i; j--)
                if(students[j-1].getName().compareTo(students[j].getName()) > 0){
                    Student temp = students[j-1];
                    students[j-1]= students[j];
                    students[j] = temp;
                }
        }
        return students;
    }
}
