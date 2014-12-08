
package Beans;

public class AudioCDBean {
    private int audiocdID;
    private String artist;
    private String recordCompany;
    private int audiocd_productID;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        this.recordCompany = recordCompany;
    }

    public int getAudiocdID() {
        return audiocdID;
    }

    public void setAudiocdID(int audiocdID) {
        this.audiocdID = audiocdID;
    }

    public int getAudiocd_productID() {
        return audiocd_productID;
    }

    public void setAudiocd_productID(int audiocd_productID) {
        this.audiocd_productID = audiocd_productID;
    }
}
