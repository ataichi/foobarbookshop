/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

import Beans.AudioCDBean;

/**
 *
 * @author Giodee
 */
public interface AudioCDDAOInterface {
    
    public boolean addAudioCD(AudioCDBean audiocd);
    public AudioCDBean getAudioCDByProductId(int id);
    
}
