package java_pro_homeworks.pr31;

public class Encryptor {


    /**
     * Получилось немного сумбурно, но свою задачу выполняет
     * */

    public static String encryptWord(String str){
        //if string is empty do nothing
        if(str.length()==0) return str;

        char[] strChars = str.toCharArray();

        //swap 2 and last
        if(str.length()>2) {
            char lastChar = strChars[strChars.length - 1];
            char secondChar = strChars[1];
            strChars[1] = lastChar;
            strChars[strChars.length - 1] = secondChar;
            str = String.valueOf(strChars);
        }

        // replace 1 with its ascii
          int asciiRepresent = (int) str.charAt(0);
          str = str.substring(1);
          str = asciiRepresent + str;

       return  str;
    }

    public  static String encryptEachWord(String fullStr){
        StringBuilder stringBuilder = new StringBuilder();

        String[] words = fullStr.split(" ");
        for (int i = 0;i< words.length;i++) {
            String word = words[i];
            stringBuilder.append(encryptWord(word));
            //if no more words do not append space
            if(i!= words.length-1) stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
