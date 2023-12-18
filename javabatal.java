/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspraktikum;

/**
 *
 * @author cakkr
 */
public class javabatal extends CLI{
    //atribut tambahan
 private int denda,durasibatal;
 
 //method tambahan
 void dataDurasiBatal(int Dbatal){
 this.durasibatal = Dbatal;
 }
 void dataDenda(int Denda){
 this.denda = Denda;
 }
 int cetakDurasiBatal(){
 return durasibatal;
 }
 int cetakDenda(){
 return denda;
 }
}

