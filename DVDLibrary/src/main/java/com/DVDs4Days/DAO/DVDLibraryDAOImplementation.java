package com.DVDs4Days.DAO;

import com.DVDs4Days.DTO.DVD;
import java.util.*;


public class DVDLibraryDAOImplementation implements DVDLibraryDAO{

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
}
