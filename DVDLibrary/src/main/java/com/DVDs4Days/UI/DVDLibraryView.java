package com.DVDs4Days.UI;

import com.DVDs4Days.DTO.DVD;

import java.util.List;

public class DVDLibraryView {
    private UserIO io = new UserIOImplementation();

    public int displayChoicesGetChoice(){
        System.out.println("-=-=-=-= Main Menu =-=-=-=-");
        System.out.println("[1] List all DVDs \n[2] Add DVD \n[3] Remove DVD \n[4] Edit DVD details  \n[5] Show DVD info / Search by title\n[6] EXIT");

        return io.readInt("Please select boi",1,6);

    }

    public DVD getNewDVDInfo (){
        System.out.println("============= ADDING DVD =============");
        String title = io.readString("Please enter the title:");
        int releaseDate = io.readInt("Please enter the year of release:",1900,2022);
        String mpaaRating = io.readString("Please enter the BBFC rating");
        String director = io.readString("Please enter the director:");
        String studio = io.readString("Please enter the studio:");
        int userRating = io.readInt("Please enter your rating out of 10:",0,10);

        DVD dvd = new DVD(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setBBFCRating(mpaaRating);
        dvd.setDirector(director);
        dvd.setStudio(studio);
        dvd.setUserRating(userRating);

        return dvd;
    }
    public void displayCreationSuccess(){
        System.out.println("========DVD successfully created========");
    }

    public void displayAllDVDs(List<DVD> DVDList){
        System.out.println("============= SHOWING ALL DVDs =============");
        for (DVD DVD : DVDList){
            String DVDInfo = String.format("Title = %s release = %d rating = %s", DVD.getTitle(),DVD.getReleaseDate(),DVD.getBBFCRating());
            System.out.println(DVDInfo);
        }

        io.readString("Press enter to continue");

    }

    public void displayDVDInfo(DVD dvd){
        if (dvd != null){
            System.out.println(dvd);
        } else {
            System.out.println("no such DVD");
        }
    }



}
