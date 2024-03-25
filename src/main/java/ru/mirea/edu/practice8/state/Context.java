package ru.mirea.edu.practice8.state;

public class Context {
    private State currentState;

    public Context(State state) {
        this.currentState = state;
    }

    void doAction() {
        currentState.doAction(this);
    }

    public void changeState(State state) {
        currentState = state;
    }

    public static void main(String[] args) {
        Context context = new Context(new FirstState());

        context.doAction();
        context.doAction();
        context.doAction();
    }
}
