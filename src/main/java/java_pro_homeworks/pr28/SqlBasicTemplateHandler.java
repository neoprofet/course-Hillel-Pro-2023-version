package java_pro_homeworks.pr28;

/*
 * Class provides ability to interact with sql requests using java code on basic level
 * */

import java.sql.*;

public class SqlBasicTemplateHandler {
    private static final String CONNECTION_STRING_PATH = "jdbc:sqlite:sample.db";

    /**
     * Create some table by template
     * <p>
     * SqlTableFieldParam represents table param in SQL, for example "age INTEGER"
     */
    public static void createSomeTable(String tableName,
                                       String sqlTableFieldParam1, String sqlTableFieldParam2,
                                       String sqlTableFieldParam3, String sqlTableFieldParam4) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING_PATH)) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE " + tableName + " (" + sqlTableFieldParam1 + ","
                    + sqlTableFieldParam2 + ","
                    + sqlTableFieldParam3 + ","
                    + sqlTableFieldParam4 + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Delete some table by template
     */
    public static void deleteSomeTable(String tableName) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING_PATH)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Insert values into table by template
     * <p>
     * SqlTableValueParam represents table value in SQL
     */
    public static void insertSomeValuesIntoSomeTable(String tableName,
                                                     String sqlTableValueParam1, String sqlTableValueParam2,
                                                     String sqlTableValueParam3, String sqlTableValueParam4) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING_PATH)) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO " + tableName + " VALUES(" + sqlTableValueParam1 + ","
                    + sqlTableValueParam2 + ","
                    + sqlTableValueParam3 + ","
                    + sqlTableValueParam4 + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print values by ResultSet
     * This method is invoked in printing method
     */
    private static void printSomeValuesByResultSet(ResultSet rs,
                                                   String fieldName1, String fieldName2,
                                                   String fieldName3, String fieldName4) throws SQLException {
        while (rs.next()) {
            System.out.println("{ ");
            System.out.println(fieldName1 + ": " + rs.getString(fieldName1) + ", ");
            System.out.println(fieldName2 + ": " + rs.getString(fieldName2) + ", ");
            System.out.println(fieldName3 + ": " + rs.getString(fieldName3) + ", ");
            System.out.println(fieldName4 + ": " + rs.getString(fieldName4));
            System.out.println("}");
            System.out.println("-----------------------------");
        }
    }

    /**
     * Print table values by template
     * <p>
     * Invokes additional method to print ResultSet
     */
    public static void printSomeValuesFromSomeTable(String tableName,
                                                    String fieldName1, String fieldName2,
                                                    String fieldName3, String fieldName4) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);

            printSomeValuesByResultSet(rs, fieldName1, fieldName2, fieldName3, fieldName4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print table values by template sorted by
     * <p>
     * Invokes additional method to print ResultSet
     * Using ORDER BY sql command
     */
    public static void printSomeValuesFromSomeTableSortedBySmth(String tableName, String sortedByFieldName,
                                                                String fieldName1, String fieldName2,
                                                                String fieldName3, String fieldName4) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName +
                    " ORDER BY " + sortedByFieldName);

            printSomeValuesByResultSet(rs, fieldName1, fieldName2, fieldName3, fieldName4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print founded table values by template sorted by
     * <p>
     * Invokes additional method to print ResultSet
     * Using ORDER BY sql command
     * Using WHERE-LIKE sql command to implement finder
     */
    public static void printFoundBySmthSomeValuesFromSomeTableSortedBySmth(String tableName, String sortedByFieldName,
                                                                String foundByFieldName, String foundByValue,
                                                                String fieldName1, String fieldName2,
                                                                String fieldName3, String fieldName4) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName +
                    " WHERE " + foundByFieldName + " LIKE + '%" + foundByValue + "%'" +
                    " ORDER BY " + sortedByFieldName);

            printSomeValuesByResultSet(rs, fieldName1, fieldName2, fieldName3, fieldName4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
