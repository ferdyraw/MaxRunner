import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinfactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coolincave extends Cool
{
    /**
     * Act - do whatever the Cuteinfactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Coolincave() {
        super();
    }
    
    public void act()
    {
        // Add your action code here.
        fall();
        out();
        
        /*if(getOneIntersectingObject(Dot.class) != null){
            Greenfoot.setWorld(new gameOver());
        }
        */
        if(getOneIntersectingObject(PortalD.class) != null){
            Greenfoot.setWorld(new Town());
        
        }
        
        checkDrink(5);
        if(isOnGround()) Running();
        else Jumping(); 
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
        if(getY() == 250) isOnGround = true;
        
        return isOnGround;            
    }
    
}
