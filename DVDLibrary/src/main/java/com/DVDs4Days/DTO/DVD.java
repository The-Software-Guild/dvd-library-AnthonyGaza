package com.DVDs4Days.DTO;

public class DVD {
    //can't be final because DVD's need to be editable
    private String title;
    private int releaseDate;
    private String BBFCRating;
    private String director;
    private String studio;
    private int userRating;

    public DVD (String title){
        this.title = title;
    }

    @Override
    public String toString(){

        return "Title - " + this.title +
                "\nYear of Release - " + this.releaseDate +
                "\nBBFC rating - " + this.BBFCRating +
                "\nDirector - " + this.director+
                "\nStudio - " + this.studio +
                "\nuserRating - " + this.userRating +
                "\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBBFCRating() {
        return BBFCRating;
    }

    public void setBBFCRating(String BBFCRating) {
        this.BBFCRating = BBFCRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}
