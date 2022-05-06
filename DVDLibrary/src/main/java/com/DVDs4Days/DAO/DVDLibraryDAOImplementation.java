package com.DVDs4Days.DAO;

import com.DVDs4Days.DTO.DVD;

import java.io.*;
import java.util.*;
import com.DVDs4Days.UI.DVDLibraryView;
import com.DVDs4Days.UI.UserIOImplementation;

public class DVDLibraryDAOImplementation implements DVDLibraryDAO{
    //public static final String ROSTER_FILE = "Library.txt";
    //public static final String DELIMITER = "::";
    private DVDLibraryView view = new DVDLibraryView();
    private UserIOImplementation io = new UserIOImplementation();

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) {
        return DVDs.put(title,dvd);

    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<>(DVDs.values());
    }

    @Override
    public DVD getDVD(String title) {
//
        return DVDs.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        return DVDs.remove(title);
    }

    @Override
    public void showDVDs(List<DVD> DVDList) {
        if (DVDList.size()>0) {
            view.displayAllDVDs(DVDList);
        } else {
            System.out.println("Library empty \n");
        }
    }

    @Override
    public boolean isEmpty() {
        if (DVDs.size()==0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void editMenuChoice(int choice, DVD uneditedDVD) {
        switch (choice){
            case 1://Title
                String newTitle = io.readString("Please enter a new title");
                uneditedDVD.setTitle(newTitle);
                break;
            case 2://release
                int newRelease = io.readInt("Please enter a new release date",1900,2022);
                uneditedDVD.setReleaseDate(newRelease);
                break;
            case 3://rating
                String newAgeRating = io.readString("Please enter a new age rating");
                uneditedDVD.setBBFCRating(newAgeRating);
                break;
            case 4://director
                String newDirector = io.readString("Please enter a new director");
                uneditedDVD.setDirector(newDirector);
                break;
            case 5://studio
                String newStudio = io.readString("Please enter a new studio");
                uneditedDVD.setStudio(newStudio);
                break;
            case 6://userRating
                int newRating = io.readInt("Please enter a new rating");
                uneditedDVD.setUserRating(newRating);
                break;
        }
    }

    @Override
    public void writeToFile() throws FileNotFoundException {
        try {
            File saveFile=new File("LibrarySaveFile");
            FileOutputStream fos=new FileOutputStream(saveFile);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(DVDs);
            oos.flush();
            oos.close();
            fos.close();
        } catch(Exception e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        try {
            File toRead=new File("LibrarySaveFile");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            //read into temp hashmap
            HashMap<String,DVD> DVDsTemp =(HashMap<String,DVD>)ois.readObject();
            //Copy into DVDs hashmap
            for (Map.Entry<String,DVD> entry : DVDsTemp.entrySet()){
                DVDs.put(entry.getKey(),entry.getValue());
            }

            ois.close();
            fis.close();
        } catch(Exception e) {
            System.out.println("File not found");
        }
    }



}

