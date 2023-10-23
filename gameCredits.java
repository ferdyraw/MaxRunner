import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameCredits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameCredits extends World
{

    /**
     * Constructor for objects of class gameCredits.
     * 
     */
    public gameCredits()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("Credits.png");
    }
    
    
    public void act()
    {
          if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
    
}
