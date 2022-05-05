package com.DVDs4Days.UI;
import java.util.Scanner;

public class UserIOImplementation implements UserIO{
    final private Scanner scanner = new Scanner(System.in);
    @Override
    //takes string prompt, shows user and takes int input with exception catching.
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int intValue = 0;
        while (invalidInput){
            try{
                String inputAsString = readString(prompt);
                intValue = Integer.parseInt(inputAsString);
                invalidInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        }
        return intValue;
    }

    @Override
    //3 argument version of previous method, same shit but won't accept unless
    // in bounds.
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
