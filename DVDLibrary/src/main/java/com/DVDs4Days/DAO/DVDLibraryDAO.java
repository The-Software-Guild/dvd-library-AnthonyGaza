package com.DVDs4Days.DAO;
import com.DVDs4Days.DTO.DVD;

import java.util.List;

public interface DVDLibraryDAO {

    DVD addDVD(String title, DVD dvd);
    List<DVD> getAllDVDs();
    DVD getDVD(String title);
    DVD removeDVD(String title);


}
