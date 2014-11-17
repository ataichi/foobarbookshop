/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.AudioCDBean;
import java.util.ArrayList;

/**
 *
 * @author Giodee
 */
public interface AudioCDDAOInterface {
    
    public boolean addAudioCD(AudioCDBean audiocd);
    public AudioCDBean getAudioCDByProductId(int id);
    public boolean deleteaudioCD(int id);
    public ArrayList<AudioCDBean> getAllAudioCD();
    
}
