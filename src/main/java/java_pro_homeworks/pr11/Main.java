package java_pro_homeworks.pr11;

import java_pro_homeworks.pr11.interfaces.IStudentPrinter;
import java_pro_homeworks.pr11.interfaces.IStudentStringConverter;
import java_pro_homeworks.pr11.observer.Human;
import java_pro_homeworks.pr11.observer.IHumanObserver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Реализовать интерфейс Comparator<Student> с помощью статических вложенных классов:
 * для сравнения по имени
 * для сравнения по возрасту
 * для сравнения по имени, а если имя одинаковое, то по возрасту
 * <p>
 * Объявить в классе Student 3 (три) статических метода, которые возвращают объекты типа Comparator<Student>,
 * реализованные в предыдущем задании.
 * <p>
 * Реализовать интерфейс Comparator<Student> с помощью анонимных классов для
 * сравнения по признакам, описанным выше.
 * <p>
 * Реализовать интерфейсы IStudentStringConverter и IStudentPrinter из предыдущих заданий
 * с помощью анонимных классов, созданных внутри метода.
 * <p>
 * Обновить класс HumanLifecycle и интерфейс IHumanLifecycleObserver,
 * реализованный на предыдущем занятии:
 * Каждый этап жизни обладает своими характеристиками, поэтому каждый метод интерфейса
 * IHumanLifecycleObserver принимает разные параметры.
 * Если характеристик несколько, то для них объявить вложенный класс и его экземпляр передать в параметрах.
 * Обязательные этапы: родился, пошел в детский сад, в школу, в ВУЗ,
 * создал семью, родил детей, умер. Добавить несколько дополнительных этапов на свое усмотрение.
 * Интерфейс IHumanLifecycleObserver
 */

public class Main {
    static List<Student> list;

    /**
     * Инициализация значений
     */
    static {
        list = new ArrayList<>();
        list.add(new Student("Albina", 2, 18, false, 122));
        list.add(new Student("Viktoria", 2, 19, false, 122));
        list.add(new Student("Yana", 1, 17, false, 122));
        list.add(new Student("Albert", 1, 20, false, 122));
        list.add(new Student("Albina", 3, 23, false, 122));
        list.add(new Student("Albina", 4, 19, false, 122));
        list.add(new Student("Yulia", 4, 21, false, 122));
        list.add(new Student("Yuriy", 1, 17, false, 122));
        list.add(new Student("Bogdan", 3, 19, false, 122));
        list.add(new Student("Pavel", 4, 21, true, 122));
        list.add(new Student("Anna", 4, 21, true, 122));
        list.add(new Student("Gena", 2, 44, true, 122));
        list.add(new Student("Grigory", 1, 17, true, 122));
    }

    /**
     * Реализовать интерфейс Comparator с помощью статических вложенных классов.
     * Сравнение по Имени
     */
    static class StudentSorterByNameTest {
        public static void main(String[] args) {
            System.out.println("\n================== NON SORTED VALUES ==================\n");
            Handler.showCollection(list);

            System.out.println("\n================== SORT BY NAME ==================\n");
            list.sort(Student.getStudentComparatorByName());
            Handler.showCollection(list);
        }
    }

    /**
     * Реализовать интерфейс Comparator помощью статических вложенных классов.
     * Сравнение по Возрасту
     */
    static class StudentSorterByAgeTest {
        public static void main(String[] args) {
            System.out.println("\n================== NON SORTED VALUES ==================\n");
            Handler.showCollection(list);

            System.out.println("\n================== SORT BY AGE ==================\n");
            list.sort(Student.getStudentComparatorByAge());
            Handler.showCollection(list);
        }
    }

    /**
     * Реализовать интерфейс Comparator с помощью статических вложенных классов.
     * Сравнение по Имени и Возрасту
     */
    static class StudentSorterByNameAndAgeTest {
        public static void main(String[] args) {
            System.out.println("\n================== NON SORTED VALUES ==================\n");
            Handler.showCollection(list);

            System.out.println("\n================== SORT BY NAME AND AGE ==================\n");
            list.sort(Student.getStudentComparatorByNameAndAge());
            Handler.showCollection(list);
        }
    }

    /**
     * Реализовать интерфейс Comparator с помощью анонимных классов.
     * Сравнение по Имени
     */
    static class StudentSorterByNameUsingAnonymousClassesTest {
        public static void main(String[] args) {

            Comparator<Student> comparator = new Comparator<>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.getName().equals(o2.getName())) return 0;
                    else if (o1.getName().compareTo(o2.getName()) > 0) return 1;
                    else return -1;
                }
            };

            System.out.println("\n================== NON SORTED VALUES ==================\n");
            Handler.showCollection(list);

            System.out.println("\n================== SORT BY NAME AND AGE ==================\n");
            list.sort(comparator);
            Handler.showCollection(list);

        }
    }

    /**
     * Реализовать интерфейс Comparator с помощью анонимных классов.
     * Сравнение по возрасту
     */
    static class StudentSorterByAgeUsingAnonymousClassesTest {
        public static void main(String[] args) {

            Comparator<Student> comparator = new Comparator<>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.getAge() == o2.getAge()) return 0;
                    else if (o1.getAge() > o2.getAge()) return 1;
                    else return -1;
                }
            };

            System.out.println("\n================== NON SORTED VALUES ==================\n");
            Handler.showCollection(list);

            System.out.println("\n================== SORT BY NAME AND AGE ==================\n");
            list.sort(comparator);
            Handler.showCollection(list);

        }
    }

    /**
     * Реализовать интерфейс Comparator с помощью анонимных классов.
     * Сравнение по возрасту
     */
    static class StudentSorterByNameAndAgeUsingAnonymousClassesTest {
        public static void main(String[] args) {

            Comparator<Student> comparator = new Comparator<>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.getName().equals(o2.getName())) return (o1.getAge() - o2.getAge());
                    else if (o1.getName().compareTo(o2.getName()) > 0) return 1;
                    else return -1;
                }
            };

            System.out.println("\n================== NON SORTED VALUES ==================\n");
            Handler.showCollection(list);

            System.out.println("\n================== SORT BY NAME AND AGE ==================\n");
            list.sort(comparator);
            Handler.showCollection(list);

        }
    }

    /**
     * Реализовать интерфейсы IStudentStringConverter и IStudentPrinter из предыдущих заданий
     * * с помощью анонимных классов, созданных внутри метода.
     */
    static class ImplementingOwnInterfacesUsingAnonymousClassesTest {

        public static void main(String[] args) {
            IStudentStringConverter converter = getStudentConverter();
            System.out.println(converter.convert(list.get(0)));

            IStudentPrinter printer = getStudentPrinter();
            printer.print(list.get(1));
        }

        //Имплементация IStudentPrinter. Метод возвращает инстанс IStudentPrinter
        public static IStudentPrinter getStudentPrinter() {
            IStudentPrinter keyValueStudentPrinter = new IStudentPrinter() {
                @Override
                public void print(Student student) {
                    System.out.println("name= " + student.getName() +
                            "\nage= " + student.getAge() +
                            "\ncourse= " + student.getCourse() +
                            "\nisBudget= " + student.isFeePaying() +
                            "\nspeciality= " + student.getSpeciality());
                }
            };
            return keyValueStudentPrinter;
        }

        //Имплементация IStudentStringConverter. Метод возвращает инстанс IStudentStringConverter
        public static IStudentStringConverter getStudentConverter() {
            IStudentStringConverter xmlStudentConverter = new IStudentStringConverter() {
                @Override
                public String convert(Student student) {
                    return "\n<student>" +
                            "\n <name>" + student.getName() + "</name>" +
                            "\n <age>" + student.getAge() + "</age>" +
                            "\n <course>" + student.getCourse() + "</course>" +
                            "\n <isBudget>" + student.isFeePaying() + "</isFeePaying>" +
                            "\n <speciality>" + student.getSpeciality() + "</speciality>" +
                            "\n</student>";
                }
            };
            return xmlStudentConverter;
        }
    }

    /**
     * Обновить класс HumanLifecycle и интерфейс IHumanLifecycleObserver,
     * реализованный на предыдущем занятии:
     * <p>
     * Каждый этап жизни обладает своими характеристиками, поэтому каждый метод интерфейса
     * IHumanLifecycleObserver принимает разные параметры.
     * <p>
     * Если характеристик несколько, то для них объявить вложенный класс и его экземпляр передать в параметрах.
     * Обязательные этапы: родился, пошел в детский сад, в школу, в ВУЗ,
     * создал семью, родил детей, умер. Добавить несколько дополнительных этапов на свое усмотрение.
     */

    static class HumanObserversUsingAnonymousClassesTest {

        public static void main(String[] args) {
            IHumanObserver father = new IHumanObserver() {
                String observerName = "Father";

                @Override
                public void onBirth(BirthParams params) {
                    if (params.isMale) System.out.println(observerName + ": Wow, it is a boy. Will be helping me");
                    else System.out.println(observerName + ": Wow, it is a girl. There will be a mother's assistant.");
                }

                @Override
                public void onStartGoingKindergarten(StartGoingKindergartenParams params) {
                    if (params.kindergartenName.equals("Sun")) {
                        System.out.println(observerName + ": My baby studying in my kindergarten");
                    } else if (params.kindergartenName.equals("Rose")) {
                        System.out.println(observerName + ": Now my baby studies in the " +
                                "kindergarten where my sister worked.");
                    }
                    else System.out.println(observerName + ": I don't like kindergarten");
                }

                @Override
                public void onStartGoingSchool(StartGoingSchoolParams params) {
                    if(params.schoolClassLetter.equals("А")) System.out.println(observerName+ ": Leader class");
                    else System.out.println(observerName+ ": Loser class, we need to move baby to A");
                }

                @Override
                public void onStartGoingUniversity(StartGoingUniversityParams params) {
                    if(params.isBudget){
                        System.out.println(observerName+ ": What a smart baby, a kid on a budget. Let the neighbor choke with envy.");
                    }
                    else{
                        System.out.println(observerName+ ": It’s a pity, but at least he entered the university," +
                                " unlike the neighbor’s granddaughter");
                    }
                }

                @Override
                public void onGetMarried(GetMarriedParams params) {
                    if(params.isSameSexMarriage){
                        System.out.println(observerName+ ": Homosexual orientation???!!! Well, kid's choice");
                    }
                    else System.out.println(observerName+ ": My second birthday");

                    if(params.age<20) System.out.println(observerName+ ":Marriage at almost the same age as mine");
                    else System.out.println(observerName+ ": For a long time fate was looking for");
                }

                @Override
                public void onHaveABaby(HaveABabyParams params) {
                    System.out.println(observerName+ ": Bring up well");

                    if(params.isBabyMale) System.out.println(observerName+ ": I have a grandson!!!!");
                    else System.out.println(observerName+ ": I have a granddaughter!!!!");
                }

                @Override
                public void onDye(DyeParams params) {
                    if(params.age<55)  System.out.println(observerName+ ": What a grief ... So early");
                    else {
                        System.out.println(observerName+ ": What a grief... Kid lived a long and happy life." +
                                " Age was: " + params.age);
                    }
                }
            };

            IHumanObserver[] observers = new IHumanObserver[]{father};
            Human human = new Human(observers);
            human.runAllLifecycles();
        }
    }
}

