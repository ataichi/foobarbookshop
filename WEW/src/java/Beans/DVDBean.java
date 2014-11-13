
package Beans;

import java.util.ArrayList;

public class DVDBean {
    private int dvdID;
    private String director;
    private String productionCompany;
    private String mainActors;
    private int dvd_productID;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public String getMainActors() {
        return mainActors;
    }

    public void setMainActors(String mainActors) {
        this.mainActors = mainActors;
    }

    public int getDvdID() {
        return dvdID;
    }

    public void setDvdID(int dvdID) {
        this.dvdID = dvdID;
    }

    public int getDvd_productID() {
        return dvd_productID;
    }
    
    public void setDvd_productID(int dvd_productID) {
        this.dvd_productID = dvd_productID;
    }
}
