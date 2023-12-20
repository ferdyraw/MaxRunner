import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstacleDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleDrop2 extends Obstacle
{
    private final int gravitasi = 1;
    public int kecepatan = 10;
    
    /**
     * Act - do whatever the Obstacle2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (getX() == 450) fall();
        else super.act();
    }
    
    public void fall(){
        setLocation(getX(), getY() + kecepatan);
        if (isOnGround()) {
            kecepatan = 0;
            setLocation(getX()-1, getY());
        } else {
            kecepatan += gravitasi;
        }
        
    }
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 275) isOnGround = true;
        
        return isOnGround;            
    }
}
