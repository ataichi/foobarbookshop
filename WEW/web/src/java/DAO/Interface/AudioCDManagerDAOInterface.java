/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;


import Beans.AudioCDBean;
import java.util.ArrayList;

public interface AudioCDManagerDAOInterface {
    
    public boolean addAudioCD (AudioCDBean audioCD);
    public boolean editAudioCD (AudioCDBean audioCD);
    public boolean deleteAudioCD (int audioCDID);
    
    public ArrayList<AudioCDBean> getAllAudioCD();
    public AudioCDBean getAudioCDByID(int id);
    public AudioCDBean getAudioCDByProductID(int productID);
    public ArrayList<AudioCDBean> getAudioCDByArtist(String artist);
    public ArrayList<AudioCDBean> getAudioCDByRecordCompany(String recordCompany);
    
}
