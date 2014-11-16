/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.MagazineBean;

public interface MagazineDAOInterface {
    
    public MagazineBean getMagazineByProductId(int id);
    public boolean deleteMagazine(int id);
    
}
