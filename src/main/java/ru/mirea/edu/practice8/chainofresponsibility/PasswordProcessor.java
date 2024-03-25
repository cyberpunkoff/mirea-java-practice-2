package ru.mirea.edu.practice8.chainofresponsibility;

public abstract class PasswordProcessor {
    private PasswordProcessor next;

    public abstract boolean checkPassword(String password);
    protected boolean checkNext(String password) {
        if (next == null) {
            return true;
        }
        return next.checkPassword(password);
    }

    public static PasswordProcessor link(PasswordProcessor first, PasswordProcessor... chain) {
        PasswordProcessor head = first;
        for (PasswordProcessor nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public static void main(String[] args) {

        PasswordProcessor entry = PasswordProcessor.link(new LongPasswordProcessor(), new CasePasswordProcessor());

        String pwd = "ads";
        String pwd1 = "asdaslkdjf;laksjf;lasjf;lasjdf";
        String pwd3 = "asdaslkdjf;*laksjf;lasjf;lasjdf";

        System.out.println(entry.checkPassword(pwd));
        System.out.println(entry.checkPassword(pwd1));
        System.out.println(entry.checkPassword(pwd3));
    }
}
