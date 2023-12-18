/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum;

/**
 *
 * @author cakkr
 */
public class javatambah extends CLI{
 //atribut tambahan
 private int durasitambah, biaya;
 
 //method tambahan
 void dataDurasiTambah(int Dtambah){
 this.durasitambah = Dtambah;
 }
 void dataBiaya(int Biaya){
 this.biaya = Biaya;
 }
 int cetakDurasiTambah(){
 return durasitambah;
 }
 int cetakBiaya(){
 return biaya;
 }
}
