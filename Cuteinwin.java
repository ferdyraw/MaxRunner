import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinwin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuteinwin extends Cute
{
    /**
     * Act - do whatever the Cuteinwin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Cuteinwin() {
        super();
        num = 3;
    }
    
    public void act()
    {
        // Add your action code here.
        fall();
        out();
        if (getX() != 298) Running();
        else Idle();
    }
    
    public void fall(){
        setLocation(getX(), getY() + kecepatan);
        if (isOnGround()) {
            kecepatan = 0;
            if (falling == true) falling = false;
        } else {
            if (falling == true) kecepatan -= gravitasi;
            else kecepatan += gravitasi;
        }
        
    }
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 305) isOnGround = true;
        
        return isOnGround;            
    }
    
    public void out() {
        setLocation(getX() + num, getY());
        if(getX() == 298){
            num = 0;
        } 
    }
}
