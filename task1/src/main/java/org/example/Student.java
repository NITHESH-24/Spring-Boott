package org.example;

public class Student {
    private String name;
    private int rollNo;
    private Credentials credentials;
    private Fee fee;
    private Marks marks;

    // Getters and setters

    public void setName(String name) { this.name = name; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public void setCredentials(Credentials credentials) { this.credentials = credentials; }
    public void setFee(Fee fee) { this.fee = fee; }
    public void setMarks(Marks marks) { this.marks = marks; }



    public void displayinfo() {
        System.out.println("Student: " + name + ", Roll No: " + rollNo);
        credentials.display();
        fee.display();
        marks.display();
    }
}