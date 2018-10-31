// 1.1.3 - Write a program that takes three integer command-line arguments and prints equal if all three are equal and not equal otherwise
import java.lang.System;
import java.util.Scanner;

public class ThreeIntegers {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide first integer");
        int first = sc.nextInt();
        System.out.println("Please provide second integer");
        int second = sc.nextInt();
        System.out.println("Please provide third integer");   
        int three = sc.nextInt();
        if (first == second && first == three) System.out.println("equal");
        else System.out.println("not equal");
        sc.close();
    }

}