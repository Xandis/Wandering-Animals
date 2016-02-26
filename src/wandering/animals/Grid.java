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
File defining a Grid
*******************************************************/

import java.util.*;
//import java.lang.*;
//import java.io.*;

class Point
{
    Point(int ix, int iy)
    {
        x = ix;
        y = iy;
    }
    
    int x;
    int y;
}

class Grid
{
    // Ctor
    Grid(int gwidth, int gheight)
    {
        width = gwidth;
        height = gheight;
        baseIcon = "~";
        grid = new String[width][height];
        rand = new Random();
    }
    
    // Methods
    void InitGrid()
    {
            for (int y = 0; y < height; y++)
            {
                    for (int x = 0; x < width; x++)
                    {
                            grid[x][y] = baseIcon;
                    }
            }
    }
    // Overloaded InitGrid function to accept a string to be used 
    // as the default grid 'icon'
    void InitGrid(String in)
    {
        baseIcon = in;
            for (int y = 0; y < height; y++)
            {
                    for (int x = 0; x < width; x++)
                    {
                            grid[x][y] = in;
                    }
            }
    }
    void PrintGrid()
    {
        for (int y = 0; y < height; y++)
        {
            String yline = "";
            for (int x = 0; x < width; x++)
            {
                yline += grid[x][y] + " ";
            }
            System.out.println(yline);
        }
    }
    // Returns true if the position in the grid has been changed,
    // meaning it is occupied.
    boolean CheckPositionTaken(Point pos)
    {
        return grid[pos.x][pos.y] != baseIcon;
    }
    // Generate an open position on the grid, or if no spots are open,
    // return a random position (the last one attempted)
    Point GenOpenPos()
    {
        Point tpos = new Point(0,0);
        
        int x = 0;
        String temp = grid[tpos.x][tpos.y];
        do
        {
            tpos.x = rand.nextInt(width);
            tpos.y = rand.nextInt(height);
            if (x++ > width * height)
            {
                System.out.println("\nSome animals may be practing their handstands on another animal...");
                break;
            }
        }
        while (grid[tpos.x][tpos.y] != baseIcon);
        
        return tpos;
    }
    String GetBaseIcon()
    {
        return baseIcon;
    }
    
    // Vars
    int width;
    int height;
    String baseIcon;
    String[][] grid;
    Random rand;
}