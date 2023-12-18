/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum;

/**
 *
 * @author cakkr
 */
public abstract class harga {
    abstract int hargatotall();
    
      private int hargamode,hargakamar,incognito,normal,gold,silver,diamond;
 String hargajam;
 int total=100000;
  int hasil(){ 
// Penerapan Polymorfisme 
 return total;
 }
 public harga (){
 hargajam = "100000";
 incognito=25000;
 normal=0;
 silver=50000;
 gold=100000;
 diamond=150000;
}

    void hargajam(int harga) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
