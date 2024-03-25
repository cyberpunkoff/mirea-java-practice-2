package ru.mirea.edu.practice8.chainofresponsibility;

public class CasePasswordProcessor extends PasswordProcessor {
    @Override
    public boolean checkPassword(String password) {
        if (password.contains("*")) {
            return checkNext(password);
        } else {
            return false;
        }
    }
}
