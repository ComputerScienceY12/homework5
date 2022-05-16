package com.williamdaw;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
/*
0 - 12,500 tax 0%
12,500 - 50,720 tax 20%
50,720 - 150,000 tax 40%
150,000 > tax 45%
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Would you like Tax(T) VAT(V) quadratic calculator (Q)");
        String strings = scanner.next().toUpperCase(Locale.ROOT);
        if(strings.equals("Q")){
            Quadraticcalulator();
        }
        System.out.println("enter a value");
        double number = scanner.nextInt();
        double answer = 0;
        if(strings.equals("T"))answer = TaxCalulator(number);
        else if (strings.equals("V"))answer = VATcalulator(number);
        System.out.println(answer);
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
        if (nums >50720 && num <= 150000){
            total += 12500;
            num -= 12500;
            total += num*0.2;
            num -= 50720;
            total += num*0.4;
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
        System.out.println("enter a value");
        int value = scanner.nextInt();
        num = num * 1.2;
        return num;
    }
    public static String Quadraticcalulator(){
        System.out.println( "if your first value is positive please place a + at the start of the input" );
        System.out.print("Enter quadratic please use s for squared");
        String quadratic_equation = scanner.next();

        String text_upper = quadratic_equation.toUpperCase();
        if (text_upper.equals("EXIT")) System.exit(0);

        quadratic_equation = quadratic_equation.replace("s", "");
        quadratic_equation = quadratic_equation.replace(" ", "");
        String[] quadratic_list = quadratic_equation.split("x");

        String a = quadratic_list[0];
        String b = quadratic_list[1];
        String c = quadratic_list[2];
        String[] list = {a, b, c};
        ArrayList<String> symbols = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {

            if (list[i].contains("+")) {
                String symbol_pos = "pos";
                symbols.add(symbol_pos);
                list[i] = list[i].replace("+", "");
            } else if (list[i].contains("-")) {
                String symbol_neg = "neg";
                symbols.add(symbol_neg);
                list[i] = list[i].replace("-", "");
            }
        }

        int int_a = Integer.parseInt(list[0]);
        int int_b = Integer.parseInt(list[1]);
        int int_c = Integer.parseInt(list[2]);

        double answer_a = 0;
        double answer_b = 0;
        if (Objects.equals(symbols.get(1), "neg")) symbols.set(1, "double");


        final double v3 = Math.pow(int_b, 2) + (-4 * -int_a * -int_c);
        if (Objects.equals(symbols.get(0), "neg") & Objects.equals(symbols.get(1), "double") & Objects.equals(symbols.get(2), "neg")) {
            var sqrt = Math.sqrt(v3);
            answer_a = ((int_b + sqrt) / (2 * -int_a));
            answer_b = ((int_b - sqrt) / (2 * -int_a));
        } else {
            final double v2 = Math.pow(int_b, 2) + (-4 * -int_a * int_c);
            if (Objects.equals(symbols.get(0), "neg") & Objects.equals(symbols.get(1), "double") & Objects.equals(symbols.get(2), "pos")) {
                final var sqrt = Math.sqrt(v2);
                answer_a = ((int_b + sqrt) / (2 * -int_a));
                answer_b = ((int_b - sqrt) / (2 * -int_a));
            } else {
                double v1 = Math.pow(int_b, 2) + (-4 * int_a * -int_c);
                if (Objects.equals(symbols.get(0), "pos") & Objects.equals(symbols.get(1), "double") & Objects.equals(symbols.get(2), "neg")) {
                    var sqrt = Math.sqrt(v1);
                    answer_a = ((int_b + sqrt) / (2 * int_a));
                    answer_b = ((int_b - sqrt) / (2 * int_a));
                } else {
                    double v = Math.pow(int_b, 2) + (-4 * int_a * int_c);
                    if (Objects.equals(symbols.get(0), "pos") & Objects.equals(symbols.get(1), "double") & Objects.equals(symbols.get(2), "pos")) {
                        var sqrt = Math.sqrt(v);
                        answer_a = ((int_b + sqrt) / (2 * int_a));
                        answer_b = ((int_b - sqrt) / (2 * int_a));
                    } else if (Objects.equals(symbols.get(0), "neg") & Objects.equals(symbols.get(1), "pos") & Objects.equals(symbols.get(2), "neg")) {

                        answer_a = ((-int_b + (Math.sqrt(v3))) / (2 * -int_a));
                        answer_b = ((-int_b - (Math.sqrt(v3))) / (2 * -int_a));
                    } else if (Objects.equals(symbols.get(0), "neg") & Objects.equals(symbols.get(1), "pos") & Objects.equals(symbols.get(2), "pos")) {
                        answer_a = ((-int_b + (Math.sqrt(v2))) / (2 * -int_a));
                        answer_b = ((-int_b - (Math.sqrt(v2))) / (2 * -int_a));
                    } else if (Objects.equals(symbols.get(0), "pos") & Objects.equals(symbols.get(1), "pos") & Objects.equals(symbols.get(2), "neg")) {
                        answer_a = ((-int_b + (Math.sqrt(v1))) / (2 * int_a));
                        answer_b = ((-int_b - (Math.sqrt(v1))) / (2 * int_a));
                    } else if (Objects.equals(symbols.get(0), "pos") & Objects.equals(symbols.get(1), "pos") & Objects.equals(symbols.get(2), "pos")) {

                        answer_a = ((-int_b + (Math.sqrt(v))) / (2 * int_a));
                        answer_b = ((-int_b - (Math.sqrt(v))) / (2 * int_a));
                    }
                }
            }
        }
        System.out.println(answer_a);
        System.out.println(answer_b);
        String string = Double. toString(answer_a) + " " + Double. toString(answer_b);
        return string;
    }
}
