package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception {

        //initiate the scanner to allow user input
        Scanner sc = new Scanner(System.in);

        //initiate readers
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        //-----------------------------------------------------------------------------------------------
        //initiate AreaBtwn Class
        AreaBtwn areaBtwn = new AreaBtwn();

        //-----------------------------------------------------------------------------------------------
        //initiate variable for restrictions
        double d1;              //lower restriction
        double d2;              //upper restriction
        double g;               //value for g(x) function
        double iteration;       //number of iteration or "slices" for functions

        //initiate variables functions
        double m;               //slope
        double k;
        double a;
        double b;
        double c;
        double d;
        boolean rad;            //see if user want to use radians or degreees

        //variable used to get user input
        String ans;             //to input function information; uses scanner
        String cont;            //to input continuation of program, or use radians; uses BufferReader

        //Variable used to access enumerated type
        ABFunctions f;

        //-----------------------------------------------------------------------------------------------
        //when user is done will become true
        //if not will continue while loop
        boolean notdone = true;

        while (notdone) {
            //-----------------------------------------------------------------------------------------------
            //reset user's choice
            String choice = null;

            //ask user what they want to do
            System.out.println("What type of function? \n" +
                    "1. Linear. \n" +
                    "2. Quadratic. \n" +
                    "3. Sine. \n" +
                    "4. Cosine. \n");

            //read user's choice
            choice = br.readLine();

            switch (choice){
                case "1": f = ABFunctions.LINEAR;
                    break;
                case "2": f = ABFunctions.QUADRATIC;
                    break;
                case "3": f = ABFunctions.SINE;
                    break;
                case "4": f = ABFunctions.COSINE;
                    break;
                default: f = ABFunctions.INVALID;
            }

            //-----------------------------------------------------------------------------------------------
            //execute so and so depending on user's choice
            switch (f) {

                //-----------------------------------------------------------------------------------------------
                //for Linear function
                case LINEAR:
                    //ask for slope as a double
                    //reads slope as user input
                    System.out.println("For equation: y = slope(x) + vertical shift");
                    System.out.println("What is your slope?");
                    m = sc.nextDouble();

                    //same thing as slope but for vertical shift
                    System.out.println("What is your vertical shift?");
                    b = sc.nextDouble();

                    //get slope and v. shift and show user the linear equation
                    System.out.println("Your equation is: y = " + m + "x + " + b + "\n");

                    //Asks fpr lower range
                    System.out.println("your domain begins at:");
                    d1 = sc.nextDouble();

                    //Asks for upper range
                    System.out.println("Your domain ends at:");
                    d2 = sc.nextDouble();

                    //Set Domain in AreaBtw Class
                    areaBtwn.setDomain(d1, d2);

                    //ask for y line restriction
                    System.out.println("g(x) =");
                    g = sc.nextDouble();
                    areaBtwn.set_Gx(g);

                    //Ask for number of slices for area?
                    System.out.println("enter the number of iteration you want:");
                    iteration = sc.nextDouble();
                    areaBtwn.setIteration(iteration);

                    //print out total area
                    areaBtwn.calAreaBtw(m, b);
                    break;

                //-----------------------------------------------------------------------------------------------
                //for quadratic functions
                case QUADRATIC:

                    //Ask for a value
                    System.out.println("For y = a ( x - b )^2 + c");
                    System.out.println("What is your a value?");
                    a = sc.nextDouble();

                    //Ask for b value
                    System.out.println("What is your b value?");
                    b = sc.nextDouble();

                    //Ask for c value
                    System.out.println("What is your c value?");
                    c = sc.nextDouble();

                    //gives user equation
                    System.out.println("Your equation is: y = " + a + "( x -" + b + ")^2 + " + c + "\n");

                    //Asks for lower range
                    System.out.println("your domain begins at:");
                    d1 = sc.nextDouble();

                    //Asks for upper range
                    System.out.println("Your domain ends at:");
                    d2 = sc.nextDouble();

                    //Set Domain in AreaBtw Class
                    areaBtwn.setDomain(d1, d2);

                    //ask for y line restriction
                    System.out.println("g(x) =");
                    g = sc.nextDouble();
                    areaBtwn.set_Gx(g);

                    //Ask for number of slices for area?
                    System.out.println("enter the number of iteration you want:");
                    iteration = sc.nextDouble();
                    areaBtwn.setIteration(iteration);

                    //print out total area
                    areaBtwn.calAreaBtw(a, b, c);
                    break;

                //-----------------------------------------------------------------------------------------------
                //for sine functions
                case SINE:
                    //ask if the user wants to use Radians
                    System.out.println("Do you want to use Radians? \n Type 'y' if you want to.");
                    ans = br.readLine();
                    if (ans.equalsIgnoreCase("y")) {
                        rad = true;
                    }else {
                        rad = false;
                    }

                    //Ask user for a value
                    System.out.println("For y = a(sin[k (x - d)]) + c");
                    System.out.println("What is your a value?");
                    a = sc.nextDouble();

                    //Ask user for k value
                    System.out.println("What is your k value?");
                    k = sc.nextDouble();

                    //Ask user for d value
                    System.out.println("What is your d value?");
                    d = sc.nextDouble();


                    //Ask user for c value
                    System.out.println("What is your c value?");
                    c = sc.nextDouble();

                    //gives user equation
                    System.out.println("Your equation is: " +
                            "y = " + a + "(sin[ " + k + " (x -  " + d + ")]) + " + c + "\n");

                    //Asks for lower range
                    System.out.println("your domain begins at:");
                    d1 = sc.nextDouble();

                    //Asks for upper range
                    System.out.println("Your domain ends at:");
                    d2 = sc.nextDouble();

                    //set domain range
                    areaBtwn.setDomain(d1, d2);

                    //ask for y line restriction
                    System.out.println("g(x) =");
                    g = sc.nextDouble();
                    areaBtwn.set_Gx(g);

                    //Ask for number of slices for area?
                    System.out.println("enter the number of iteration you want:");
                    iteration = sc.nextDouble();
                    areaBtwn.setIteration(iteration);

                    //print out total area
                    areaBtwn.calAreaBtw (f, a, k, c, d, rad);

                    break;

                //-----------------------------------------------------------------------------------------------
                //for cosine function
                case COSINE:
                    //ask if the user wants to use Radians
                    System.out.println("Do you want to use Radians? \n Type 'y' if you want to.");
                    ans = br.readLine();
                    if (ans.equalsIgnoreCase("y")) {
                        rad = true;
                    }else {
                        rad = false;
                    }

                    //Ask user for a value
                    System.out.println("For y = a(cos[k (x - d)]) + c");
                    System.out.println("What is your a value?");
                    a = sc.nextDouble();

                    //Ask user for k value
                    System.out.println("What is your k value?");
                    k = sc.nextDouble();

                    //Ask user for d value
                    System.out.println("What is your d value?");
                    d = sc.nextDouble();

                    //Ask user for c value
                    System.out.println("What is your c value?");
                    c = sc.nextDouble();

                    //gives user equation
                    System.out.println("Your equation is: " +
                            "y = " + a + "(cos[ " + k + " (x -  " + d + ")]) + " + c + "\n");

                    //Asks for lower range
                    System.out.println("your domain begins at:");
                    d1 = sc.nextDouble();

                    //Asks for upper range
                    System.out.println("Your domain ends at:");
                    d2 = sc.nextDouble();

                    //set domain range
                    areaBtwn.setDomain(d1, d2);

                    //ask for y line restriction
                    System.out.println("g(x) =");
                    g = sc.nextDouble();
                    areaBtwn.set_Gx(g);

                    //Ask for number of slices for area?
                    System.out.println("enter the number of iteration you want:");
                    iteration = sc.nextDouble();
                    areaBtwn.setIteration(iteration);

                   /* //change domains from degrees to radians
                    //b/c java default is radians
                    if (rad) {
                        //Set Domain in AreaBtw Class
                        areaBtwn.setDomain(d1, d2);

                    }else {
                        d1 = Math.toRadians(d1);
                        d2 = Math.toRadians(d2);

                        //Set Domain in AreaBtw Class
                        areaBtwn.setDomain(d1, d2);
                    }//closes if-else statement*/

                    //print out total area
                    areaBtwn.calAreaBtw(f, a, k, c, d, rad);
                    break;

                //-----------------------------------------------------------------------------------------------
                //if user does not enter valid answer
                default:
                    System.out.println("Sorry. This is not an option.");
                    break;

            }//end of switch

            //-----------------------------------------------------------------------------------------------
            //ask if user want sto continue
            System.out.println("Do you want to continue?");
            cont = br.readLine();

            //if user is done close program
            if (cont.equalsIgnoreCase("no")){
                notdone = false;

            }//close if statement;

            //data is reset before beginning while loop again
            areaBtwn.resetData();

        }//closes while loop

    }//close main method

}//closes main class


