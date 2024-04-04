package ru.mirea.edu.practice8.state;

public abstract class State {
    private State nextState;
    public abstract void doAction(Context context);
}
