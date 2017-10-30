package com.company;

/**
 * Created by 84674tra on 19/10/2017.
 */
public class AreaBtwn {

    //initiate variable that set function restriction
    public double g;            //value of g(x)
    public double domain1;      //lower restriction
    public double domain2;      //upper restriction
    public double slice;        //number of iterations

    //initiate variable to needed to find area under function
    public double area;         //total area under slope
    double rect;                //area of each slice
    public double h;            //y value at a particular iteration
    public double width;        //how large the "base" of each iteration is

    //initiate variables for functions
    double m1;
    double k1;
    double a1;
    double b1;
    double c1;
    double d1;

    //initiate variable
    ABFunctions f1;             //used to decide to use cosine or sine function
    boolean rad;

    //-----------------------------------------------------------------------------------------------
    //reset all the data
    public void resetData(){
        g = 0;
        domain1 = 0;
        domain2 = 0;
        slice = 0;

        area = 0;
        rect = 0;
        h = 0;
        width = 0;
    }

    //-----------------------------------------------------------------------------------------------
    //set g(x)
    public void set_Gx (double b){
        g = b;
    }

    //set domain
    public void setDomain (double low, double high){
        domain1 = low;
        domain2 = high;
    }

    //set number for slices
    public void setIteration (double n){
        slice = n;
    }

    //-----------------------------------------------------------------------------------------------
    //display area method
    private void displayArea(){
        System.out.println("Area: " + area + " units squared");
    }

    //-----------------------------------------------------------------------------------------------
    //For Linear Function
    private void setLineData (double m, double b){
        m1 = m;
        b1 = b;
    }

    //Calculate Area of Under and Over Linear Slope
    //Variable from equation: y = mx + b
    private double calcAreaLinear (){

        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        h = m1*domain1 + b1 - g;

        //find how wide each slice is
        width = (domain2 - domain1) / slice;

        //will do loop as long as number of area left is less than number of sections
        for (int x = 0; x < slice; x ++ ){

            //calculate the area of the rectangle
            //width is how big each slice is
            rect = Math.abs(width*h);

            //move point to next slice
            domain1 += width;

            //find new y value
            //add area of rectangle to overall area
            h = m1*domain1 + b1 - g;
            area += rect;

        }//end for loop

        return area;

    }//close calLinearArea Method

    //will be called in main class to set, calculate and display info
    public double calcAreaBtw (double m, double b){
        setLineData(m, b);
        calcAreaLinear();
        displayArea();
        return area;
    }

    //-----------------------------------------------------------------------------------------------
    //For Quadratic Function
    //set data for a ( x - h )^2 + c
    private void setQuadraticData (double a, double h, double c){
        a1 = a ;
        b1 = h ;
        c1 = c;
    }

    //Calculate Area Under Quadratic Slope
    //Variables for equation: y = a ( x - b )^2 + c
    private double calcAreaQuadratic (){
        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        h = a1*((domain1 - b1)*(domain1 - b1)) + c1 - g;

        //find how wide each slice is
        width = (domain2 - domain1) / slice;

        //will do loop as long as number of area left is less than number of sections
        for (int x = 0; x < slice; x ++ ){

            //calculate the area of the rectangle
            //width is how big each slice is
            rect = Math.abs(width*h);

            //move point to next slice
            domain1 += width;

            //find new y value
            //add area of rectangle to overall area
            h = a1*((domain1 - b1)*(domain1 - b1)) + c1 - g;
            area += rect;

        }//end for loop

        return area;
    }//closes calAreaQuadratic method

    //will be called in main class to set, calculate and display info
    public double calcAreaBtw (double a, double h, double c){
        setQuadraticData(a, h, c);
        calcAreaQuadratic();
        displayArea();
        return area;
    }
    //-----------------------------------------------------------------------------------------------
    //for Sinusoidal Funtions
    //set data for y = a(sin[k (x - d)]) + c
    private void setSinusoidalData (ABFunctions f, double a, double k, double c, double d, boolean degree){
        f1 = f;
        a1 = a;
        k1= k;
        c1 = c;
        d1 = d;
        rad = degree;

        if (rad == false){
            domain1 = Math.toRadians(domain1);
            domain2 = Math.toRadians(domain2);
            setDomain(domain1, domain2);
        }else{
            setDomain(domain1,domain2);
        }

    }

    //--------------------------------------------------------------
    //Calculate Area Under Sin Slope
    private double calcAreaSine (){

        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        h = a1*(Math.sin(k1* (domain1 - d1))) + c1 - g;

        //find how wide each slice is
        width = (domain2 - domain1) / slice;

        //will do loop as long as number of area left is less than number of sections
        for (int x = 0; x < slice; x ++ ){

            //calculate the area of the rectangle
            //width is how big each slice is
            rect = Math.abs(width*h);

            //move point to next slice
            domain1 += width;

            //find new y value
            //add area of rectangle to overall area
            h = a1*(Math.sin(k1*(domain1 - d1))) + c1 - g;
            area += rect;

        }//end for loop
        return area;
    }//close calAreaSine function

    //--------------------------------------------------------------
    //Calculate Area of Under and Over Slope
    private double calcAreaCosine (){

        //reset area
        area = 0;

        //Find y-value at the beginning of the domain
        //i.e. its length
        h = a1*(Math.cos(k1*(domain1 - d1))) + c1 - g;

        //find how wide each slice is
        width = (domain2 - domain1) / slice;

        //will do loop as long as number of area left is less than number of sections
        for (int x = 0; x < slice; x ++ ){

            //calculate the area of the rectangle
            //width is how big each slice is
            rect = Math.abs(width*h);

            //move point to next slice
            domain1 += width;

            //find new y value
            //add area of rectangle to overall area
            h = a1*(Math.cos(k1*(domain1 - d1))) + c1 - g;
            area += rect;

        }//end for loop

        return area;

    }//close calAreaCosine function

    //--------------------------------------------------------------
    //will be called in main class to set, calculate and display info
    public double calcAreaBtw (ABFunctions f, double a, double k, double c, double d, boolean degree){

        //sets data for Trig functions
        setSinusoidalData(f, a, k, c, d, degree);

        //
        if (f1 == ABFunctions.SINE) {
            calcAreaSine();

        }else if (f1 == ABFunctions.COSINE){
            calcAreaCosine();
        }//close if-else statement

        displayArea();
        return area;
    }//close calAreaBtw method

}//close AreaBtwn class
