package org.example;

public class Marks {
    private int subject1;
    private int subject2;
    private int subject3;

    public void setSubject1(int subject1){this.subject1 = subject1;}
    public void setSubject2(int subject2){this.subject2 = subject2;}
    public void setSubject3(int subject3){this.subject3 = subject3;}

    public void display(){
        System.out.println("Marks: S1="+subject1 + " S2="+subject2+" S3="+subject3);
    }
}