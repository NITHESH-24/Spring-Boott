package org.example;

public class Fee {
    private int amount;
    private String status;

    public void setAmount(int amount){this.amount = amount;}
    public void setStatus(String status){this.status = status;}

    public void display(){
        System.out.println("Fee: " + amount + " - " + status);
    }
}