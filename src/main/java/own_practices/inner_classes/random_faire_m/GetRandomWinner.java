package own_practices.inner_classes.random_faire_m;


public class GetRandomWinner {
    public static void main(String[] args) {

        String[] participants = {
                //       "theme",
                "yulka.spool",
                "syavka",
                "gladko27",
        };

        int randomIndex = (int) Math.floor(Math.random() * participants.length);
        System.out.println("winner: " + participants[randomIndex]);

    }
}

