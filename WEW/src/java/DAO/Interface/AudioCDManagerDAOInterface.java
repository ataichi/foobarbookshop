/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

/**
 *
 * @author jao
 */

import Beans.AudioCDBean;
import java.util.ArrayList;

public interface AudioCDManagerDAOInterface {
    
    public boolean addAudioCD (AudioCDBean audioCD);
    public boolean editAudioCD (AudioCDBean audioCD);
    public boolean deleteAudioCD (int audioCDID);
    
    public AudioCDBean getAudioCDById (int ID);
    public ArrayList<AudioCDBean> getAllAudioCDByArtist(String artist);
    public ArrayList<AudioCDBean> getAllAudioCDByRecordCompany(String recordCompany);
    public ArrayList<AudioCDBean> getAllAudioCD();
    public AudioCDBean getAudioCDByProductId(int id);
    
}
