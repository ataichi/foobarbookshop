
import Beans.DVDBean;
import DAO.Implementation.DVDManagerDAOImplementation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danica
 */
public class Checking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DVDBean dvdbean = new DVDBean();
        DVDManagerDAOImplementation dvddao = new DVDManagerDAOImplementation();
        dvdbean = dvddao.getDVDByProductID(1);
        dvdbean.setMainActors("okay");
        dvddao.editDVD(dvdbean);
        
    }
    
}
