/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wandering.animals;

/**
 *
 * @author wayne.walker
 */
/*******************************************************
Simple java program showing off small skills
- inheritance
  - polymorphism
- multidimensional arrays
- string manipulation
- utilizing command line input
*******************************************************/

import java.util.*;
//import java.lang.*;
//import java.io.*;



public class WanderingAnimals
{
    public static void main(String[] args)
    {
        // Getting command line args for size of grid
        // Defaults in case there is no input from the command line
        int w = 10;
        int h = 10;
        
        ArrayList<String> inputargs = new ArrayList<String>();
        for (String x : args)
        {
            inputargs.add(x);
        }
        if (inputargs.size() == 2)
        {
            w = Integer.parseInt(inputargs.get(0));
            h = Integer.parseInt(inputargs.get(1));
        }
        
        // Main Program
        System.out.println("Welcome to watching cats wander.\n");
        
        //Random rand = new Random();
        Scanner keyboard = new Scanner(System.in);
        
        // All animal types will be pushed onto this array
        ArrayList<Animal> myAnimals = new ArrayList<Animal>();
        
        // ------------------- NEW stuffs
        
        // Definintion/Creation of the grid which animals will be
        // displayed on.
        Grid myGrid = new Grid(w,h);
	myGrid.InitGrid();
        
        // - Experimenting with polymorphism here
        // - Used an "Animal" base type to store all Cats/Bats in but
        // due to polymorphism, the correct class will be called at runtime
        // - Initializes each entity to a free space on the grid. If there 
        // is no free space, then two or more entities will be placed on
        // eachother and a message will be printed stating such.
        Animal myCat = new Cat("Willbur", myGrid.GenOpenPos());
            myAnimals.add(myCat);
        myCat = new Cat("Bucky", myGrid.GenOpenPos());
            myAnimals.add(myCat);
        myCat = new ScottishFold("Yarlie", myGrid.GenOpenPos());
            myAnimals.add(myCat);
        Bat bat = new Bat("Flappy", myGrid.GenOpenPos());
            myAnimals.add(bat);
        // -------------------
        
        // Experimenting with polymorphism here
        // Used an "Animal" base type to store all Cats/Bats in but
        // due to polymorphism, the correct class will be called at runtime
        /*Animal myCat = new Cat("Willbur");
            myAnimals.add(myCat);
        myCat = new Cat("Bucky", rand.nextInt(w), rand.nextInt(h));
            myAnimals.add(myCat);
        myCat = new ScottishFold("Yarlie", rand.nextInt(w), rand.nextInt(h));
            myAnimals.add(myCat);
        Bat bat = new Bat("Flappy", rand.nextInt(w), rand.nextInt(h));
            myAnimals.add(bat);*/
        
        /*myCat.Sleep();
        myCat.Eat();
        myCat.Prowl();*/
        
        // Definintion/Creation of the grid which animals will be
        // displayed on.
        /*Grid myGrid = new Grid(w,h);
	myGrid.InitGrid();*/
        
        Point pos;
        for (Animal x : myAnimals)
        {
            System.out.println("----------");
            // Is this a cat?
            if (x instanceof Cat)
                System.out.println(x.name + " is a cat!");
            else
                System.out.println(x.name + " is NOT a cat! It's a " + x.getclass() + "!");
                
                x.Eat();
                x.Sleep();
                
            // Update position of the cat on the grid
            pos = x.getPos();
            myGrid.grid[pos.x][pos.y] = x.getid();
        }
        
        // Main loop
        int end = 1;
        String sinput;
        char cinput;
        do
        {
            System.out.println("\n\n----------");
            System.out.println("Commands:");
            System.out.println("e - Eat");
            System.out.println("w - Wander");
            System.out.println("x - Exit");
            System.out.println("\nEnter command: ");
            cinput = keyboard.next().charAt(0);
            
            switch (cinput)
            {
                // TODO - entries for all commands plus function calls
                case 'w':
                case 'W':
                    // TODO
                    break;
                case 'e':
                case 'E':
                    for (Animal x : myAnimals)
                    {
                        x.Eat();
                    }
                    break;
                case 'x':
                case 'X':
                    end = 0;
                    break;
                default:
                    System.out.println("\nPlease enter a valid command. ");
                    break;
            }
            
            // Print out the grid
            System.out.println();
            myGrid.PrintGrid();
        }
        while (end != 0);
        
        System.out.println("\nAnimals are done wandering.");
    }
}