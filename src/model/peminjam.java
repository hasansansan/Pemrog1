package model;


public class peminjam {
    private String nNIK;
    private String pPlat_motor;
    private int bayar;
    private String Namaa;
    private String Typee;
    
    public String getNamaa() {
        return Namaa;
    }

    public void setNamaa(String Namaa) {
        this.Namaa = Namaa;
    }

    public String getTypee() {
        return Typee;
    }

    public void setTypee(String Typee) {
        this.Typee = Typee;
    }
    
    
    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }
   

    public String getnNIK() {
        return nNIK;
    }

    public void setnNIK(String nNIK) {
        this.nNIK = nNIK;
    }

    public String getpPlat_motor() {
        return pPlat_motor;
    }

    public void setpPlat_motor(String pPlat_motor) {
        this.pPlat_motor = pPlat_motor;
    }

    
}
