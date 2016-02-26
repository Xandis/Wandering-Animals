/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wandering.animals;

/**
 *
 * @author wayne.walker
 * */
 
class Animal
{
    // Ctors
    Animal()
    {
        name = "No name given";
        id = "X";
        pos = new Point(0,0);
        timesFed = 0;
    }
    Animal(String aName)
    {
        name = aName;
        // Use the first letter of the name as the 'icon' to be displayed
        // on the grid.
        id = aName.substring(0,1);
        pos = new Point(0,0);
        timesFed = 0;
    }
    Animal(String aName, int aPosx, int aPosy)
    {
        name = aName;
        // Use the first letter of the name as the 'icon' to be displayed
        // on the grid.
        id = aName.substring(0,1);
        pos = new Point(aPosx,aPosy);
        timesFed = 0;
    }
    Animal(String aName, Point aPos)
    {
        name = aName;
        // Use the first letter of the name as the 'icon' to be displayed
        // on the grid.
        id = aName.substring(0,1);
        pos = aPos;
        timesFed = 0;
    }
    
    // Methods
    void Sleep()
    {
        System.out.println(name + " is now sleeping.");
    }
    
    void Eat()
    {
        if (++timesFed > 5)
        {
            System.out.println(name + " has eaten too recently.");
        }
        else
        {
            System.out.println(name + " is now eating.");
        }
    }
    
    Point getPos()
    {
        return pos;
    }
    
    String getid()
    {
        return id;
    }
    
    String getclass()
    {
        return this.getClass().getSimpleName();
    }
    
    // Vars
    String name;
    String id;
    Point pos;
    int timesFed;
}

class Cat extends Animal
{
    // Ctors
    Cat()
    {
        super();
    }
    Cat(String aName)
    {
        super(aName);
    }
    Cat(String aname, int aPosx, int aPosy)
    {
        super(aname, aPosx, aPosy);
    }
    Cat(String aname, Point aPos)
    {
        super(aname, aPos);
    }   
    
    // Methods
    void Prowl()
    {
        System.out.println(name + " is now prowling.");
    }
    
    void Wander()
    {
        System.out.println(name + " has wandered.");
        
        
    }
    
    String getclass()
    {
        return this.getClass().getSimpleName();
    }
    
    // Vars
}

class ScottishFold extends Cat
{
    // Ctors
    ScottishFold()
    {
        super();
    }
    ScottishFold(String aName)
    {
        super(aName);
    }
    ScottishFold(String aName, int aPosx, int aPosy)
    {
        super(aName, aPosx, aPosy);
    }
    ScottishFold(String aName, Point aPos)
    {
        super(aName, aPos);
    }
    
    // Methods
    String getclass()
    {
        return this.getClass().getSimpleName();
    }
    
    // Vars
}

class Bat extends Animal
{
    // Ctors
    Bat()
    {
        super();
    }
    Bat(String aName)
    {
        super(aName);
    }
    Bat(String aName, int aPosx, int aPosy)
    {
        super(aName, aPosx, aPosy);
    }
    Bat(String aName, Point aPos)
    {
        super(aName, aPos);
    }
    
    // Methods
    String getclass()
    {
        return this.getClass().getSimpleName();
    }
    
    
    // Vars
}