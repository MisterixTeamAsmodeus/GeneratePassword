package com.company;

public class Main {

    public static void main(String[] args) {
        GeneratePassword password = new GeneratePassword(3);
        password.useAPP_CASE_SYMBOL(true);
        password.useLOW_CASE_SYMBOL(true);
        password.useNUMBER(true);
        password.useSERVICE(true);
        System.out.print(password.generate());
    }
}
