import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOverBackground extends World
{

    /**
     * Constructor for objects of class gameOverBackground.
     * 
     */
    public gameOverBackground()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("R")){
            Greenfoot.setWorld(new gameBackground());
            
        }
        if(Greenfoot.isKeyDown("E")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}
