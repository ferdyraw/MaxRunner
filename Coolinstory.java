import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coolinstory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coolinstory extends Cool
{
    /**
     * Act - do whatever the Coolinstory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int num = 2;
    public void act()
    {
        setLocation(getX() + num, getY());
        
        if(getX() == 150){
            num = 0;
        } else Running();
        stop();
    }
    public void stop(){
        if(num == 0){
          Idle();  
        }
    }
    
    
}
