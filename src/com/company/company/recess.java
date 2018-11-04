package com.company.company;


public class recess {

    String recessDate, returnDate;

    public recess(String recessDate, String returnTime) {
        this.recessDate = recessDate;
        this.returnDate = returnTime;
    }

    public String getRecessDate() {
        return recessDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String calculateTime(String recessDate, String returnTime){
        int first = Integer.parseInt(recessDate);
        int second = Integer.parseInt(returnTime);

        return String.valueOf(second - first);
    }
}
