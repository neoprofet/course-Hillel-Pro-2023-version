package java_pro_homeworks.pr13.factories;

public class DataFactory {
    public static String generateRandomNumber(){
        StringBuilder builder = new StringBuilder();
        builder.append("+38095")
                .append((int) (Math.random() * 9) + 1)
                .append((int) (Math.random() * 9) + 1)
                .append((int) (Math.random() * 9) + 1)
                .append((int) (Math.random() * 9) + 1)
                .append((int) (Math.random() * 9) + 1)
                .append((int) (Math.random() * 9) + 1)
                .append((int) (Math.random() * 9) + 1);
        return builder.toString();
    }

        public static class ContactData{
            private static final String[] names = new String[]{"Denis","Ilya", "Elena", "Sasha", "Nick", "Ludmila",
                    "Marina", "Maria", "Pavel", "Ihor", "Nikolay"};

            public static String[] getNames(){
                return names;
            }

            public static String getRandomName(){
                int randomIndex =  (int) Math.floor(Math.random() * names.length);
                return names[randomIndex];
            }
        }

        public static class MessageData {
            private static final String[] messages = new String[]{
                    "Привет",
                    "Привет, как дела?",
                    "Добрый день",
                    "Добрый вечер",
                    "Спокойной ночи",
                    "Спасибо",
                    "Как дела?",
                    "Все хорошо",
                    "Согласен",
                    "Удачи тебе",
                    "Пока"};
            public static String[] getMessages(){
                return messages;
            }

            public static String getRandomMessage(){
                int randomIndex =  (int) Math.floor(Math.random() * messages.length);
                return messages[randomIndex];
            }
        }


    }

