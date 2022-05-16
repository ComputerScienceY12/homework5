package com.williamdaw;

import java.util.Scanner;
/*
0 - 12,500 tax 0%
12,500 - 50,720 tax 20%
50,720 - 150,000 tax 40%
150,000 > tax 45%
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like Tax(T) VAT(V) quadratic calculator (Q)");
        String value = scanner.next();
        double number;
        switch (value){
            case "T":
                number = Double.parseDouble(value);
                TaxCalulator(number);
            case "V":
                number = Double.parseDouble(value);
                TaxCalulator(number);
            case "Q":
                Quadraticcalulator(value);

        }
    }
    public static double TaxCalulator(double num){
        double total = 0;
        double nums = num;
        if(nums <= 12500){
            total += 12500;
            return total;
        }
        if(nums > 12500 && nums <= 50720){
            total += 12500;
            nums -= 12500;
            total += nums*0.2;
        }
        if (nums >50720 && nums <= 150000){
            total += 12500;
            nums -= 12500;
            total += nums*0.2;
            nums -= 50720;
            total += nums*0.4;
        }
        if (nums < 150000){
            total += 12500;
            nums -= 12500;
            total += nums*0.2;
            nums -= 50720;
            total += nums*0.4;
            nums -= 150000;
            total += nums*0.45;
        }
        return total;
    }
    public static double VATcalulator(double num){
        num = num * 1.2;
        return num;
    }
    public static String Quadraticcalulator(String num){
        return num;
    }
}
