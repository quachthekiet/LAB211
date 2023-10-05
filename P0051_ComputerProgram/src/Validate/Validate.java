package Validate;

import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kiet
 */
public class Validate {

    public static Scanner scanner = new Scanner(System.in);

    public int getAnPositiveIntegerNumber(String message) {
        

        while (true) {
            try {
                
                int number = Integer.parseInt(getString(message));

                if (number < 0) {
                    throw new PositiveNumberException("Invalid, input must be a positive number");
                }

                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid, input must be a integer number!");
            } catch (PositiveNumberException ex) {
                System.out.println(ex.getMessage());

            }

        }
    }

    public double getAPositiveDoubleNumber(String message, double min, double max) {
        
        while (true) {
            try {
                
                double number = Double.parseDouble(getString(message));
                if (number <= min || number >= max) {
                    throw new PositiveNumberException("Invalid, please inputnumber in range " + min + " - " + max);  
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid, input must be a number!");
            } catch (PositiveNumberException ex) {
                System.out.println(ex.getMessage());
                
            }
        }
    }

    public String getString(String message) {
        while (true) {
            System.out.print(message);
            String string = scanner.nextLine();
            if (string == null) {
                System.out.println("Invalid, input is empty please input again!");
            } else {
                return string.trim();
            }

        }
    }

    public String getOperator() {
        while (true) {
            String operator = getString("Enter operator: ");

            switch (operator) {
                case "+":
                    return operator;
                case "-":
                    return operator;
                case "*":
                    return operator;
                case "/":
                    return operator;
                case "^":
                    return operator;
                case "=":
                    return operator;

                default:
                    System.out.println("Please input: (+, -, *, /, ^, =)");

            }
        }

    }

    public double getDivision(Double numerator, Double denominator) {
        
        while(true) {
            try {
                if(denominator == 0) {
                    throw new ArithmeticException();
                
                }
                    
            return (numerator / denominator);
            } catch (ArithmeticException e) {
                System.out.println("Can not divided by 0, please input again!");
                denominator = getAPositiveDoubleNumber("Input number: ",Double.MIN_VALUE, Double.MAX_VALUE);
            }
            
        }
        
        
        
    }

}
