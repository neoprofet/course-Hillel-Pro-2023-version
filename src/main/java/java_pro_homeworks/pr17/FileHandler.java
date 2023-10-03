package java_pro_homeworks.pr17;

import java.io.*;

public class FileHandler {

    /**
     * �������� ����� � ����
     * */
    static void writeTextToFile(File file, String data) throws IOException {
        try (PrintWriter writer = new PrintWriter
                (new FileOutputStream(file))) {
            writer.println(data);
        }
    }

    /**
     * �������� ������, ���������� ��� ������ � �����
     */

    public static String getTextFromFile(File file){
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.ready()){
                stringBuilder.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * ������� ����. ���� ���������� ������� � �������
     * ���� ���������� ���������� (����. "src.files"), -> ������
     * */
    static File getFile(String path){
        File file = new File(path);
        try {
            if(!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
