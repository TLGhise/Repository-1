package Tema8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DivideByZero, InvalidOperator {
        Calculator c = new Calculator();
        OperatorHandle oh = new OperatorHandle();

        System.out.println("Addition");
        System.out.println(c.addition(2.0,3.9) + oh.canHandle("+"));
        System.out.println("Subtraction");
        System.out.println(c.subtraction(2.0,3.9) + oh.canHandle("-"));
        System.out.println("Multiply");
        System.out.println(c.multiply(2.0,3.9) + oh.canHandle("*"));
        System.out.println("Divide");
        System.out.println(c.divide(2.0,3.9) + oh.canHandle("/"));

        //throw RunTimeException
      System.out.println(c.divide(1.0,0.0) + oh.canHandle("/") );

        //throw custom Exception
       System.out.println(c.addition(2.0,3.9) + oh.canHandle("f") );




//        boolean runagain = false;
//            Double result =.0;
//            List<Double> input = new ArrayList<>();
//            Scanner scanner = new Scanner(System.in);
//            do {
//                    System.out.println("enter first Number:");
//                    input.add(scanner.nextDouble());
//
//                    System.out.println("enter the second number:");
//                    input.add(scanner.nextDouble());
//
//                System.out.println("Enter the operator: ");
//
//
//                System.out.println("answer" + result);
//
//                System.out.println("do you want to try again? [Y/N]");
//                runagain = scanner.next().equals("Y")?true:false;
//            } while(runagain);
//            System.out.println("program finished");
//            scanner.close();
//
     }
    }

