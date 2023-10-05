/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0051_computerprogram;

import Validate.Validate;

/**
 *
 * @author kiet
 */
public class P0051_ComputerProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validate validate = new Validate();

        while (true) {
            menu();
            int userchoice = validate.getAnPositiveIntegerNumber("Please choose an option: ");

            switch (userchoice) {
                case 1:
                    normalCaculator();
                    break;

                case 2:
                    bmiCalculator();
                    break;

                case 3:
                    System.out.println("Good bye!");
                    return;

                default:
                    System.out.println("Invalid, please choose an option above!");

            }
        }
    }

    public static void menu() {
        System.out.println("Caculator program");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        
    }

    public static void normalCaculator() {
        Validate validate = new Validate();
        String operator = "";
        double memory = validate.getAPositiveDoubleNumber("Enter number: ",-Double.MAX_VALUE,Double.MAX_VALUE);

        while (!operator.equals("=")) {

            operator = validate.getOperator();
            switch (operator) {
                case "+":
                    memory += validate.getAPositiveDoubleNumber("Enter number: ",Double.MIN_VALUE,Double.MAX_VALUE);
                    System.out.println("Memory:" + memory);
                    break;
                case "-":
                    memory -= validate.getAPositiveDoubleNumber("Enter number: ",Double.MIN_VALUE,Double.MAX_VALUE);
                    System.out.println("Memory:" + memory);
                    break;
                case "*":
                    memory *= validate.getAPositiveDoubleNumber("Enter number: ",Double.MIN_VALUE,Double.MAX_VALUE);
                    System.out.println("Memory:" + memory);
                    break;
                case "/":
                    memory = validate.getDivision(memory, validate.getAPositiveDoubleNumber("Input number: ",-Double.MAX_VALUE,Double.MAX_VALUE));
                    System.out.println("Memory:" + memory);
                    break;
                case "^":
                    memory = Math.pow(memory, validate.getAPositiveDoubleNumber("Input number: ",Double.MIN_VALUE,Double.MAX_VALUE));
                    System.out.println("Memory:" + memory);
                    break;
                case "=":

                    System.out.println("Results: " + memory);

            }

        }

    }

    public static void bmiCalculator() {
        Validate validate = new Validate();
        System.out.println("-----BMI Calculator-----");
        double weight = validate.getAPositiveDoubleNumber("Enter Weight: ",0,Double.MAX_VALUE);
        double height = validate.getAPositiveDoubleNumber("Enter Height: ",0,Double.MAX_VALUE);
        double bmiNumber = weight/Math.pow(height, 2);
        System.out.format("BMI Number: %.2f\n", bmiNumber);
        if(bmiNumber < 19) 
            System.out.println("Under-standard");
        else if(bmiNumber >=19 && bmiNumber <= 25 )
            System.out.println("Standard");
        else if(bmiNumber > 25 && bmiNumber <=30)
            System.out.println("Overweight");
        else if(bmiNumber > 30 && bmiNumber <= 40)
            System.out.println("Fat - should lose weight");
        else
            System.out.println("Very fat - should lose weight imemediatly");
    }
    
    
}
