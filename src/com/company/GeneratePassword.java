package com.company;

import java.util.ArrayList;
import java.util.Random;

public class GeneratePassword {
    private final char[] SERVICE = new char[]{'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'};
    private final char[] NUMBER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final char[] APP_CASE_SYMBOL = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final char[] LOW_CASE_SYMBOL = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final int use_SERVICE = 0;
    private final int use_NUMBER = 1;
    private final int use_APP_CASE_SYMBOL = 2;
    private final int use_LOW_CASE_SYMBOL = 3;
    private int length;
    private ArrayList<Integer> list = new ArrayList<>();

    public GeneratePassword(int length) {
        if (length > 0)
            this.length = length;
    }

    public GeneratePassword() {
        this.length = 1;
    }

    public void useSERVICE(boolean use) {
        if (use) {
            if (list.indexOf(use_SERVICE) < 0)
                list.add(use_SERVICE);
        } else {
            list.remove(use_SERVICE);
        }
    }

    public void useNUMBER(boolean use) {
        if (use) {
            if (list.indexOf(use_NUMBER) < 0)
                list.add(use_NUMBER);
        } else {
            list.remove(use_NUMBER);
        }
    }

    public void useAPP_CASE_SYMBOL(boolean use) {
        if (use) {
            if (list.indexOf(use_APP_CASE_SYMBOL) < 0)
                list.add(use_APP_CASE_SYMBOL);
        } else {
            list.remove(use_APP_CASE_SYMBOL);
        }
    }

    public void useLOW_CASE_SYMBOL(boolean use) {
        if (use) {
            if (list.indexOf(use_LOW_CASE_SYMBOL) < 0)
                list.add(use_LOW_CASE_SYMBOL);
        } else {
            list.remove(use_LOW_CASE_SYMBOL);
        }
    }

    public void setPassLen(int passLen) {
        if (passLen > 0)
            this.length = passLen;
    }

    public String generate() throws IndexOutOfBoundsException {
        if (list.size() == 0)
            throw new IndexOutOfBoundsException("No characters selected");
        StringBuilder pass = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int used = list.get(random.nextInt(list.size()));
            switch (used) {
                case use_SERVICE:
                    pass.append(SERVICE[random.nextInt(SERVICE.length)]);
                    break;
                case use_NUMBER:
                    pass.append(NUMBER[random.nextInt(NUMBER.length)]);
                    break;
                case use_APP_CASE_SYMBOL:
                    pass.append(APP_CASE_SYMBOL[random.nextInt(APP_CASE_SYMBOL.length)]);
                    break;
                case use_LOW_CASE_SYMBOL:
                    pass.append(LOW_CASE_SYMBOL[random.nextInt(LOW_CASE_SYMBOL.length)]);
                    break;
            }
        }
        return pass.toString();
    }
}
