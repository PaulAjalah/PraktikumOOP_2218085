/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum;

/**
 *
 * @author cakkr
 */

public class CLI extends harga implements namaadmin{
    String nama,jenis,judul, mode;
    int durasi,tlp, harga,total=100000;;
int settlp;
    private String doublebed,singlebed,normal,vip,vvip;
    //membuat objek
public void cli(){
    this.nama = "Paul Borneo Putra";
  
    }
   @Override
 public int hasil() { // Penerapan Polymorfisme yaitu Dynamic Polimorfisme
 return (( hargatotall() + total));
 }
    public String getDoublebed() {
        return doublebed;
    }

    public void setDoublebed(String doublebed) {
        this.doublebed = doublebed;
    }

    public String getSinglebed() {
        return singlebed;
    }

    public void setSinglebed(String singlebed) {
        this.singlebed = singlebed;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getVvip() {
        return vvip;
    }

    public void setVvip(String vvip) {
        this.vvip = vvip;
    }
    
       
    void datamode(String mode){
 this.mode = mode;
    }
    void datajenis(String jenis){
 this.jenis = jenis;
    }
 void hargajam(int harga){
 this.harga = harga;
 }
     String cetaknama(){
 return nama;
 }        
      int cetaktlp(){                                         
 return tlp;
 }
       String cetakmode(){
 return mode;
 }
       String cetakjenis(){
 return jenis;
 }
       int cetakhargajam(){
 return harga;}
       public CLI(){
           this.judul = "PERSEWAAN KAMAR HOTEL"; 
}

    void cetaknama(String text) {
        this.nama=nama; }

    void setnama(String text) {
        this.nama=text;}

    void settlp(int text) {
        this.tlp=text;}
   
    @Override
    int hargatotall() {
         return total;
    }

    @Override
    public String namaadmin() {
        return namaadmin;
    }

   
}
