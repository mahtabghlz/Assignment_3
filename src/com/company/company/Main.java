package com.company.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException, ParseException {
        Scanner scan = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);

        Date date = new Date();
        Date date1 = new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calender1 = Calendar.getInstance();
        calendar.setTime(date);
        calender1.setTime(date1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int permission = 4;

        int hour1 = calender1.get(Calendar.HOUR_OF_DAY);
        int minute1 = calender1.get(Calendar.MINUTE);
        int second1 = calender1.get(Calendar.MINUTE);

        String timeStamp = null, timeStamp1 = null, timeStamp2 = null, timeStamp3 = null;

        int getEnetrTimes = hour + minute + second;
        int getExitTime = hour + minute + second;

        ArrayList<employee> employeeArrayList = new ArrayList<>();
        ArrayList<user> userArrayList = new ArrayList<>();
        ArrayList<entery> enteryArrayList = new ArrayList<>();
        ArrayList<String> save = new ArrayList<>();

        String getName, getLastName, getNatCode, getAdd, getMobile, getPassword, getUserName;
        int getBirth;
        // ArrayList

        employee employeeObj = null;
        user user = null;
        entery enteryObj = null;
        recess recessObj = null;
        foodReservation food = null;

        while (true) {
            System.out.println("1) Sign up");
            System.out.println("2) Log in");
            System.out.println("3) Exit");
            System.out.print("Enter here :");
            int firstinput = scan.nextInt();

            if (firstinput == 1) {
                System.out.print("Hi...Please enter your name : ");
                getName = scan.next();
                System.out.print("Now enter your last name : ");
                getLastName = scan.next();
                System.out.print("National Code : ");
                getNatCode = scan.next();
                System.out.print("Mobile : ");
                getMobile = scan.next();
                System.out.print("Adrress : ");
                getAdd = scan.next();
                System.out.print("Birth Year : ");
                getBirth = scan.nextInt();
                employeeObj = new employee(getName, getLastName, getNatCode, getAdd, getMobile, getBirth);

                System.out.println("*--------------------------------------------*");
                System.out.println("Welcome " + employeeObj.name);
                System.out.println("Name : " + employeeObj.name + " | Last Name : " + employeeObj.lastName);
                System.out.println("National Code : " + employeeObj.natCode + " | Age : " + employeeObj.age(year));
                System.out.println("Address : " + employeeObj.address);
                System.out.println("*--------------------------------------------*");

                employeeArrayList.add(new employee(getName, getLastName, getNatCode, getMobile, getAdd, getBirth));

                System.out.print("Now Choose a user name for your self : ");
                getUserName = scan.next();
                do {
                    System.out.print("Enter a 8 character password : ");
                    getPassword = keyboard.next();

                    if (getPassword.length() == 8) {
                        System.out.println("Password was checked and saved");
                        System.out.println("*--------------------------------------------*");
                        user = new user(getName, getLastName, getNatCode, getAdd, getMobile, getBirth, getUserName, getPassword);
                        userArrayList.add(user);
                        break;
                    } else {
                        System.out.println("Password must be 8 characters!!");
                    }

                    userArrayList.add(new user(getName, getLastName, getNatCode, getMobile, getAdd, getBirth, getUserName, getPassword));

                } while (true);


            } else if (firstinput == 2) {
                System.out.print("Username : ");
                getUserName = scan.next();
                System.out.print("Password(eight character) : ");
                getPassword = scan.next();

                for (int i = 0; i < userArrayList.size(); i++)
                    if ((userArrayList.get(i).username.equals(getUserName)) && (userArrayList.get(i).password.equals(getPassword))) {
                        do {
                            System.out.println("a) Entery");
                            System.out.println("b) Recess");
                            System.out.println("c) Food reservation");
                            System.out.println("d) Cancel");
                            System.out.print("Enter here :");
                            String input2 = scan.next();

                            if (input2.equals("a")) {                //entery
                                System.out.println("Welcome " + user.name + " " + user.lastName + " do you want to import your entery time :");
                                System.out.println("---------------");
                                System.out.println("|1)YES    2)NO|");
                                System.out.println("---------------");

                                int input3 = scan.nextInt();
                                enteryObj = new entery(getEnetrTimes, getExitTime);

                                if (input3 == 1) {

                                    System.out.println("----------------------------");
                                    System.out.println("|1)Enter Time    2)Exit Time|");
                                    System.out.println("----------------------------");
                                    int input4 = scan.nextInt();

                                    if (input4 == 1) {
                                        timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                                        timeStamp1 = timeStamp;
                                        System.out.println(timeStamp);

                                    } else if (input4 == 2) {
                                        timeStamp2 = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                                        timeStamp3 = timeStamp2;
                                        System.out.println(timeStamp2);

                                        long diffrence = Main.time(timeStamp, timeStamp3);
                                        System.out.println("Active hours : " + diffrence);
                                    }

                                } else if (input3 == 2) {
                                    System.out.println("You cancel this operation");
                                    break;
                                }


                            } else if (input2.equals("b")) {         //recess
                                permission = permission - 1;
                                int duration = 0;
                                int day2;

                                if (permission > 0) {
                                    System.out.println("Today is:" + year + "/" + month + "/" + day);
                                    System.out.print("Please enter your recess duration :");
                                    duration = scan.nextInt();
                                    day2 = day + duration;


                                    String recessDate = year + "/" + month + "/" + day;
                                    String returnTime = year + "/" + month + "/" + day2;
                                    recessObj = new recess(recessDate, returnTime);

                                    System.out.println("You got a " + duration + " day recess until " + returnTime);

                                } else if (permission == 0) {
                                    System.out.println("You can not do this proccess!");
                                    break;
                                }


                            } else if (input2.equals("c")) {         //foodReservation
                                food = new foodReservation(5, 5);
                                food.dailyChart(5, 5);

                                int chooseFood;
                                System.out.println("Saturday :");
                                chooseFood = scan.nextInt();

                                if (chooseFood == 1) {
                                    save.add(food.foods[0][2]);
                                } else if (chooseFood == 2) {
                                    save.add(food.foods[0][4]);
                                }

                                System.out.println("Sunday :");
                                chooseFood = scan.nextInt();

                                if (chooseFood == 1) {
                                    save.add(food.foods[1][2]);
                                } else if (chooseFood == 2) {
                                    save.add(food.foods[1][4]);
                                }

                                System.out.println("Monday :");
                                chooseFood = scan.nextInt();

                                if (chooseFood == 1) {
                                    save.add(food.foods[2][2]);
                                } else if (chooseFood == 2) {
                                    save.add(food.foods[2][4]);
                                }

                                System.out.println("Tuesday :");
                                chooseFood = scan.nextInt();

                                if (chooseFood == 1) {
                                    save.add(food.foods[3][2]);
                                } else if (chooseFood == 2) {
                                    save.add(food.foods[3][4]);
                                }

                                System.out.println("Wednesday :");
                                chooseFood = scan.nextInt();

                                if (chooseFood == 1) {
                                    save.add(food.foods[4][2]);
                                } else if (chooseFood == 2) {
                                    save.add(food.foods[4][4]);
                                }

                                System.out.println(food.foods[0][0] + save.get(0));
                                System.out.println(food.foods[1][0] + save.get(1));
                                System.out.println(food.foods[2][0] + save.get(2));
                                System.out.println(food.foods[3][0] + save.get(3));
                                System.out.println(food.foods[4][0] + save.get(4));

                            } else if (input2.equals("d")) {
                                break;
                            } else {
                                System.out.println("Invalid input!");
                            }
                        } while (true);

                    } else {
                        System.out.println("You're not logged in!");
                    }

            } else if (firstinput == 3) {
                break;
            } else {
                System.out.println("Please try again!input was not valid...");
            }
        }
    }

    public static long time(String time1, String time2) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        return (difference / 1000);
    }
}
