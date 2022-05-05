package com.DVDs4Days.Controller;
import com.DVDs4Days.DTO.DVD;
import com.DVDs4Days.UI.DVDLibraryView;
import com.DVDs4Days.UI.UserIOImplementation;
import com.DVDs4Days.DAO.DVDLibraryDAOImplementation;

import java.util.List;

public class DVDLibraryController {
    DVDLibraryView view = new DVDLibraryView();
    UserIOImplementation io = new UserIOImplementation();
    DVDLibraryDAOImplementation dao = new DVDLibraryDAOImplementation();
    public void run(){
        boolean continuing = true;

        while (continuing){
            int menuChoice = view.displayChoicesGetChoice();

            switch (menuChoice){
                case 1:
                    showAllDVDs();
                    break;
                case 2:
                    createNewDVD();
                    break;
                case 3:
                    removeDVD();
                    break;
                case 4:
                    System.out.println("Editing DVD - TODO");
                    break;
                case 5:
                    findDVD();
                    break;
                case 6:
                    System.out.println("Exiting - TODO");
                    continuing = false;
                default:
                    System.out.println("UNKNOWN command - TODO");
            }
        }
        System.out.println("cya");

    }

    private void createNewDVD(){
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreationSuccess();
        System.out.println(newDVD);

    }

    private void showAllDVDs(){
        List<DVD> DVDList = dao.getAllDVDs();
        if (DVDList.size()>0) {
            view.displayAllDVDs(DVDList);
        } else {
            System.out.println("Library empty \n");
        }
    }

    private void removeDVD(){
        String toDelete = io.readString("please enter the title of the DVD you want to delete");
        dao.removeDVD(toDelete);
        System.out.println("DVD successfully removed, title - " + toDelete);

    }

    private void findDVD(){
        String toGet = io.readString("Please enter the title of the DVD you want to retrieve the details for");

        view.displayDVDInfo(dao.getDVD(toGet));
    }

}
