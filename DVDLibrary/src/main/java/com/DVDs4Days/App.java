package com.DVDs4Days;

import com.DVDs4Days.Controller.DVDLibraryController;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();



    }
}
