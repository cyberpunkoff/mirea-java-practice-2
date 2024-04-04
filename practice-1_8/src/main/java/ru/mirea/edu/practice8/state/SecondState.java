package ru.mirea.edu.practice8.state;

public class SecondState extends State {
    @Override
    public void doAction(Context context) {
        context.changeState(new FirstState());
        System.out.println("Находимся во втором состоянии");
    }
}
