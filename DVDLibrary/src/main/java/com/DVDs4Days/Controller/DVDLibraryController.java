package com.DVDs4Days.Controller;
import com.DVDs4Days.DTO.DVD;
import com.DVDs4Days.UI.DVDLibraryView;
import com.DVDs4Days.UI.UserIOImplementation;
import com.DVDs4Days.DAO.DVDLibraryDAOImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DVDLibraryController {
    DVDLibraryView view = new DVDLibraryView();
    UserIOImplementation io = new UserIOImplementation();
    DVDLibraryDAOImplementation dao = new DVDLibraryDAOImplementation();
    public void run() throws FileNotFoundException {
        boolean continuing = true;
        dao.readFromFile();
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
                    editDVD();
                    break;
                case 5:
                    findDVD();
                    break;
                case 6:
                    view.exitMessage();
                    continuing = false;
            }
        }
        System.out.println("Goodbye.");
        dao.writeToFile();

    }

    private void createNewDVD(){
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreationSuccess();
        System.out.println(newDVD);

    }

    private void showAllDVDs(){
        List<DVD> DVDList = dao.getAllDVDs();
        dao.showDVDs(DVDList);

    }

    private void removeDVD(){
        String toDelete = io.readString("please enter the title of the DVD you want to delete");
        DVD dvdToDelete = dao.removeDVD(toDelete);
        if (dvdToDelete!=null) {
            System.out.println("DVD successfully removed, title - " + toDelete);
        } else {
            System.out.println("DVD not in library, check spelling or case.");
        }
    }

    private void findDVD(){
        String toGet = io.readString("Please enter the title of the DVD you want to retrieve the details for");

        view.displayDVDInfo(dao.getDVD(toGet));
    }

    private void editDVD(){
        if (dao.isEmpty()==true){
            System.out.println("EMTPY");
        } else {
            System.out.println("Here's a list of DVDs currently in the library:");
            showAllDVDs();
            String titleToEdit = io.readString("Please enter the title of the DVD you want to edit: ");
            view.displayDVDInfo(dao.getDVD(titleToEdit));
            view.showFieldsMenu();
            int field = io.readInt("Which field would you like to edit?",1,6);
            dao.editMenuChoice(field,dao.getDVD(titleToEdit));
            System.out.println("Here is the updated information");
            view.displayDVDInfo(dao.getDVD(titleToEdit));
        }
    }

}
