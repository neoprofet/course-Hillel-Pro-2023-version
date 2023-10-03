package java_pro_homeworks.pr28;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu provides next possibilities:
 * <p>
 * 1. Student table creating,
 * <p>
 * 2. Student table deleting,
 * <p>
 * 3. Student table randomly filler,
 * <p>
 * 4. Inserting one random student to table,
 * <p>
 * 5. Inserting one student to table,
 * <p>
 * 6. Student table printing,
 * <p>
 * 7. Student sorted table printing,
 * <p>
 * 8. Student sorted found values printing
 */

public class TaskMenuProvider {
    /**
     * Basic menu logic
     * <p>
     * Scanner exception (InputMismatchException) handling was implemented
     * Correct number entering validation was implemented
     */
    public static void startWithMenu() {
        while (true) {
            showMenuText();
            Scanner scanner = new Scanner(System.in);
            int menuVar = -1;
            try {
                menuVar = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Entered value is not integer number");
            }
            if (menuVar >= 0 && menuVar <= 9) {
                switch (menuVar) {
                    case 0:
                        return;
                    case 1: {
                        createStudentTable();
                        break;
                    }
                    case 2: {
                        deleteStudentTable();
                        break;
                    }
                    case 3: {
                        fillStudentsTableRandomlyViaScanner();
                        break;
                    }
                    case 4: {
                        insertOneRandomStudent();
                        break;
                    }
                    case 5: {
                        fillStudentsTableManuallyViaScanner();
                        break;
                    }
                    case 6: {
                        showStudentTable();
                        break;
                    }
                    case 7: {
                        showStudentTableSortedByName();
                        break;
                    }
                    case 8: {
                        showStudentSortedFoundValues();
                        break;
                    }
                    case 9: {
                        System.out.println("Easter egg");
                        break;
                    }
                }

            } else System.out.println("Enter correct number (from 0 to 8)");

        }
    }

    /**
     * Text for UI menu printer
     */
    private static void showMenuText() {
        System.out.println("0 - Exit");
        System.out.println("1 - Create students table");
        System.out.println("2 - Delete students table");
        System.out.println("3 - Fill students table randomly");
        System.out.println("4 - Insert one student to table randomly");
        System.out.println("5 - Insert one student to table manually");
        System.out.println("6 - Show students table");
        System.out.println("7 - Show students table sorted by name");
        System.out.println("8 - Find students by name (results will be sorted)");
        System.out.println("Enter required number to get started: ");
    }

    /**
     * Creates DB empty table of students
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void createStudentTable() {
        SqlBasicTemplateHandler.createSomeTable("students",
                "id INTEGER", "name VARCHAR(100)",
                "surname VARCHAR(100)", "speciality INTEGER");
    }

    /**
     * Delete table of students
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void deleteStudentTable() {
        SqlBasicTemplateHandler.deleteSomeTable("students");
    }

    /**
     * Show table of students
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void showStudentTable() {
        SqlBasicTemplateHandler.printSomeValuesFromSomeTable("students",
                "id", "name",
                "surname", "speciality");
    }

    /**
     * Show table of students which sorted by name
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void showStudentTableSortedByName() {
        SqlBasicTemplateHandler.printSomeValuesFromSomeTableSortedBySmth("students", "name",
                "id", "name",
                "surname", "speciality");
    }

    /**
     * Show results of searching by name, students also sorted by name
     * Uses additional class handler (SqlBasicTemplateHandler)
     * <p>
     * TODO make scanner validation
     */
    private static void showStudentSortedFoundValues() {
        Scanner scanner = new Scanner(System.in);
        String likeStr = "";
        likeStr = scanner.nextLine();
        SqlBasicTemplateHandler.printFoundBySmthSomeValuesFromSomeTableSortedBySmth("students",
                "name", "name", likeStr,
                "id", "name",
                "surname", "speciality");
    }

    /**
     * Inserts one random student to students table,
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void insertOneRandomStudent() {
        SqlBasicTemplateHandler.insertSomeValuesIntoSomeTable("students",
                String.valueOf(StudentData.getRandomId()),
                "'" + StudentData.getRandomPersonName() + "'",
                "'" + StudentData.getRandomPersonSurname() + "'",
                String.valueOf(StudentData.getRandomSpeciality()));
    }

    /**
     * Inserts amount random students to students table
     * RAW LOGIC
     * <p>
     * Uses additional method that inserts one random student to students table
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void fillStudentsTableRandomly(int count) {
        for (int i = 0; i < count; i++) {
            insertOneRandomStudent();
        }

    }

    /**
     * Inserts amount random students to students table
     * User interaction (scanner) provided
     * <p>
     * Uses additional method that inserts one random student to students table
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void fillStudentsTableRandomlyViaScanner() {
        Scanner scanner = new Scanner(System.in);
        int count;
        while (true) {
            System.out.println("Enter count of random students to insert");
            try {
                count = scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Entered value is not integer number");
                continue;
            }
            if (count <= 0 || count >= 10000) {
                System.out.println("Entered value is out of range. Enter from 1 to 10_000 ");
            } else {
                fillStudentsTableRandomly(count);
                System.out.println(count + " students have been inserted to table");
                return;
            }

        }

    }

    /**
     * Inserts student to students table manually
     * User interaction (scanner) provided
     * Scanner basic validation provided
     * <p>
     * Uses additional method that inserts one random student to students table
     * Uses additional class handler (SqlBasicTemplateHandler)
     */
    private static void fillStudentsTableManuallyViaScanner() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter ID: ");
            int field1;
            try {
                field1 = scanner.nextInt();
                if (field1 < 0) {
                    System.out.println("id cannot be negative");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entered value is not integer number");
                continue;

            }
            /*there is a problem of the Scanner class,
             after I have entered a number into the console ( variable scan.nextInt(); ),
             my program skipped the next line in the code ( scan.nextLine();)
             This line of invoking nextline() again solves it;
             */
            scanner.nextLine();

            System.out.println("Enter Name: ");
            String field2 = scanner.nextLine();

            System.out.println("Enter Surname: ");
            String field3 = scanner.nextLine();

            System.out.println("Enter speciality");
            int field4;
            try {
                field4 = scanner.nextInt();
                if (field4 < 0) {
                    System.out.println("speciality cannot be negative");
                    continue;
                }
                if (field4 > 1000) {
                    System.out.println("speciality is incorrect");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entered value is not integer number");
                continue;

            }

            SqlBasicTemplateHandler.insertSomeValuesIntoSomeTable("students",
                    String.valueOf(field1),
                    "'" + field2 + "'",
                    "'" + field3 + "'",
                    String.valueOf(field4));
            System.out.println("Your values were saved");
            return;
        }
    }


}
