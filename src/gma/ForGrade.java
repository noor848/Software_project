/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class ForGrade{
    public  static Integer stID;
    public static String stName;

   public ForGrade(String stName,int stID){
   this.stName=stName;
   this.stID=stID;



   }
    

    public int getstID() {
        return this.stID;
     }
    public void setstID(int id) {
          this.stID=id;
     }

    public String getstName() {
        return stName;
     }
    public void setstName(String name) {
          this.stName=name;
     }

}