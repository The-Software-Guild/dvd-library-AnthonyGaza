package com.DVDs4Days.UI;

public interface UserIO {

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    String readString(String prompt);
}