package java_pro_homeworks.pr24.tasks;

/*
�������� � ������

Cancel � future ������ ���� isInterrupted=true ��� ��� ����� �������� ����� ����� ������� ��������� ����������
���� �� ������ ����� �� ����������� ������ (���� Thread.sleep) �� �� ����������� � ���� � catch InterruptedEx-on
� ��� �������� ��� ������ ������.

� ���� ������ �� ������� �������� ����� �� isInterrupted, ���������� ��������� ������ � catch InterruptedEx-on.
������: ������ �� ������ ��� ���������� �������� � catch InterruptedEx-on.
��� ����� �� ������ ��������� � ��� ������ ����� ����� ����.
�� ��� �� ���, � �������� ������ ���� ������ � ������ ����� Thread.sleep �� ����� �� ���������� ����� ��� ����� ����
� catch InterruptedEx-on, ���� ���� ��� �������� �� � ��������� ���. ������?

�����: ����� ����� �������� Thread.sleep(), �� ��������� � ��������� ��� �
��������� ���� "������������" (interrupt flag).
���� ���� ���������� (�� ���� ����� ��� ������� � ������� interrupt() �� ��� �� ����� ���),
�� ����� Thread.sleep() ���������� InterruptedException.
� ���� ������, ���� "������������" �� ��������� �������������, � �� �������� �������������.


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
