import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Energy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Energy extends Actor
{
    /**
     * Act - do whatever the Energy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int energy = 0;
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage("Energy : " + energy, 30, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK));
    }
    
    public void addEnergy(){
        energy++;
    }
    
    public void resetEnergy(){
        energy = 0;
    }
}
