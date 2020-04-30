package com.company;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long ts_b, ts_e;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввести дані вручну\n"+
                           "Ввести дані з файла\n"+
                           "Згенерувати випадково дані\n");
        int menu = scanner.nextInt();
        switch (menu){
            case 1: {

                System.out.println("Введіть розмірність матриці NxN");
                Graf g = new Graf(scanner.nextInt());
                ts_b = Calendar.getInstance().getTimeInMillis();
                g.fillGraf();
                ts_e = Calendar.getInstance().getTimeInMillis();
                System.out.println("Time "+(ts_e-ts_b));
                break;
            }
            case 2: {
                System.out.println("Введіть назву файла .txt");
                String ditectory = scanner.next();
                ts_b = Calendar.getInstance().getTimeInMillis();
                Graf g = new Graf(ditectory);
                ts_e = Calendar.getInstance().getTimeInMillis();
                System.out.println("Time "+(ts_e-ts_b));
                break;
            }
            case 3: {
                ts_b = Calendar.getInstance().getTimeInMillis();
                Graf g = new Graf();
                ts_e = Calendar.getInstance().getTimeInMillis();
                System.out.println("Time "+(ts_e-ts_b));
                break;
        }
    }


    }
}
