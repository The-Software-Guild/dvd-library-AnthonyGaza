package com.DVDs4Days.DAO;

import com.DVDs4Days.DTO.DVD;
import java.util.*;
import com.DVDs4Days.UI.DVDLibraryView;
import com.DVDs4Days.UI.UserIOImplementation;

public class DVDLibraryDAOImplementation implements DVDLibraryDAO{
    private DVDLibraryView view = new DVDLibraryView();
    private UserIOImplementation io = new UserIOImplementation();

    private Map<String, DVD> DVDs = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) {
        //throw new UnsupportedOperationException("Not supported yet.");

        return DVDs.put(title,dvd);

    }

    @Override
    public List<DVD> getAllDVDs() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return new ArrayList<>(DVDs.values());
    }

    @Override
    public DVD getDVD(String title) {
//        throw new UnsupportedOperationException("Not supported yet.");
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


}

