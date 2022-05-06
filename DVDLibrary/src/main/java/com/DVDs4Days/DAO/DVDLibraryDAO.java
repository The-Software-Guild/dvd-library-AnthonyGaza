package com.DVDs4Days.DAO;
import com.DVDs4Days.DTO.DVD;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface DVDLibraryDAO extends Serializable {

    DVD addDVD(String title, DVD dvd);
    List<DVD> getAllDVDs();
    DVD getDVD(String title);
    DVD removeDVD(String title);

    void showDVDs(List<DVD> DVDList);

    boolean isEmpty();
    void editMenuChoice(int choice, DVD uneditedDVD);
    void writeToFile() throws FileNotFoundException;
    void readFromFile() throws FileNotFoundException;


}
