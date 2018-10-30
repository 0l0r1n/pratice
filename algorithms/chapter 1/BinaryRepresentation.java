import java.lang.System;
import java.util.Scanner;

// 1.1.9 - Write a code fragment that puts the binary representation of a positive integer n into a string s
public class BinaryRepresentation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide a positive integer ");
        int i = sc.nextInt();
        if (i <= 0) throw new IllegalArgumentException("That ain't a positive integer");
        String s = Integer.toBinaryString(i);
        System.out.println(s);
    }

}