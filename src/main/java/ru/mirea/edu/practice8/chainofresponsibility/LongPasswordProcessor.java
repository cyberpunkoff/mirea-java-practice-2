package ru.mirea.edu.practice8.chainofresponsibility;

public class LongPasswordProcessor extends PasswordProcessor {
    @Override
    public boolean checkPassword(String password) {
        if (password.length() < 5) {
            return false;
        } else {
            return checkNext(password);
        }
    }
}
