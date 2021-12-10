/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gma;

/**
 *
 * @author Noor
 */
public class ParentSee {
    
     String nameSubject;
     int grade;
    int studentId;
    String studentName;
    int classId;
   
   
   public ParentSee(String nameSubject,int grade,int studentId,String studentName,int classId){
   this.classId=classId;
   this.grade=grade;
   this.studentId=studentId;
   this.nameSubject=nameSubject;
   this.studentName=studentName;
   
   
   }
   
   
   
   

    public void classId(int classId) {
         this.classId=classId;
    }

    public void grade(int grade) {
      this.grade=grade;
    }

    public void studentId(int  studentId) {
         this.studentId=studentId;
    }

    public void nameSubject(String nameSubject) {
       this.nameSubject=nameSubject;
    }

    public void studentName(String studentName) {
           this.studentName=studentName;

    }

 
    

    public int classId() {
        return classId;
    }
    public int grade() {
        return grade;
    }

     public   int studentId() {
        return studentId;
    }

    public String nameSubject() {
        return nameSubject;
    }

    public String studentName() {
        return studentName;
    }

 
   
 

  
   
   
   
   
   
    
    
    
    
    
    
    
    
}
