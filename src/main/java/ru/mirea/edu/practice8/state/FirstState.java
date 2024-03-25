package ru.mirea.edu.practice8.state;

public class FirstState extends State {
    @Override
    public void doAction(Context context) {
        context.changeState(new SecondState());
        System.out.println("Находимся в первом состоянии");
    }
}
