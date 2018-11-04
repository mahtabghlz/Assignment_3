package com.company.company;

public class foodReservation {

    public int row,column;
    String[][] foods ={
            {"Saturday: ","  ","1) Kabab","         ","2) Spagetti"},
            {"Sunday: ","    ","1) Lasagna","       ","2) KormeSabzi"},
            {"Monday: ","    ","1) Pirogi","        ","2) Keyme"},
            {"Tuesday: ","   ","1) Pizza","         ","2) KingFisher"},
            {"Wednesday: "," ","1) Fried Chicken"," ","2) Pasta"}
    };

    public foodReservation(int row, int columm) {
        this.row = row;
        this.column = column;
    }

    public void dailyChart(int x,int y){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.format(foods[i][j]);
            }
            System.out.println("");
        }
    }

}
