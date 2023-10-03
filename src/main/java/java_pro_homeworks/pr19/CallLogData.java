package java_pro_homeworks.pr19;

public class CallLogData {
    private String[] names = new String[]{"Ivan", "Anastasiya", "Denis", "Mary",
            "Ann", "Nick", "Pavel", "Ihor", "Elena", "Ilya"};

    public static String generateRandomNumber() {
        return "+38095" +
                ((int) (Math.random() * 9) + 1) +
                ((int) (Math.random() * 9) + 1) +
                ((int) (Math.random() * 9) + 1) +
                ((int) (Math.random() * 9) + 1) +
                ((int) (Math.random() * 9) + 1) +
                ((int) (Math.random() * 9) + 1) +
                ((int) (Math.random() * 9) + 1);
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
