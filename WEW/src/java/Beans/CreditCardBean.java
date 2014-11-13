
package Beans;

import java.sql.Date;

public class CreditCardBean {
    protected String cardname;
    protected String cardno;
    protected String cardtype;
    protected Date cardexpdate;
    protected int creditcardID;

    public int getCreditcardID() {
        return creditcardID;
    }

    public void setCreditcardID(int creditcardID) {
        this.creditcardID = creditcardID;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public Date getCardexpdate() {
        return cardexpdate;
    }

    public void setCardexpdate(Date cardexpdate) {
        this.cardexpdate = cardexpdate;
    }
    
       
}
