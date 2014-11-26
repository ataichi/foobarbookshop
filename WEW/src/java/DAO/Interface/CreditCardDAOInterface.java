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

import Beans.CreditCardBean;
import java.sql.Date;
import java.util.ArrayList;

public interface CreditCardDAOInterface {
    
    public boolean addCreditCard (CreditCardBean creditCard);
    public boolean editCreditCard (CreditCardBean creditCard);
    public boolean deleteCreditCard (int creditCardID);
    
    public ArrayList<CreditCardBean> getCreditCardByCardName(String cardName);
    public CreditCardBean getCreditCardByCardNo(String cardNo);
    public CreditCardBean getCreditCardByCreditCardID(int creditcardID);
    
    public ArrayList<CreditCardBean> getCreditCardByCardType(String cardType);
    public ArrayList<CreditCardBean> getCreditCardByExpDate (Date from, Date to);
    
    public CreditCardBean getLastCreditCard();
    public int getUserCreditCard (int customerID);
}
