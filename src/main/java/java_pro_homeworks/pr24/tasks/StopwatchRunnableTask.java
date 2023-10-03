package java_pro_homeworks.pr24.tasks;

/*
ПРОБЛЕМА И ВОПРОС

Cancel у future ставит флаг isInterrupted=true так что нужна проверка флага чтобы сделать поддержку прерывания
Если мы сейчас стоим на блокирующем методе (напр Thread.sleep) то мы просыпаемся и идем в catch InterruptedEx-on
и там решается что делать дальше.

В этом случае не сделано проверку флага на isInterrupted, завершение программы только в catch InterruptedEx-on.
Вопрос: почему мы всегда при прерывании попадаем в catch InterruptedEx-on.
Как будто мы всегда прерываем в тот момент когда поток спит.
Но это не так, я пробывал писать куча циклов и логики после Thread.sleep но после ее выполнения поток все равно идет
в catch InterruptedEx-on, даже если его прервали не в состоянии сна. Почему?

Ответ: Когда поток вызывает Thread.sleep(), он переходит в состояние сна и
проверяет флаг "прерванности" (interrupt flag).
Если флаг установлен (то есть поток был прерван с помощью interrupt() до или во время сна),
то метод Thread.sleep() генерирует InterruptedException.
В этом случае, флаг "прерванности" не очищается автоматически, и он остается установленным.


*/
public class StopwatchRunnableTask implements Runnable {

    private int seconds = 0;

    //int test = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                seconds++;

                /*  for (int i = 0; i < 1000000; i++) {
                    test++;
                    System.out.println("thread are not sleeping. It is doing smth" + test++);
                }*/

            } catch (InterruptedException e) {
                System.out.println("Time has passed: " + seconds);
                return;
            }
            System.out.println("Iteration: " + seconds);
        }
    }
}
