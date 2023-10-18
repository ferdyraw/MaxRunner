import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World
{
    Counter counter = new Counter();
    
    public gameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void prepare(){
        counter.changeFontSize(20);
        addObject(counter, 300, 280);
    }
    
    public void act(){
        

        if(Greenfoot.isKeyDown("R")){
            Greenfoot.setWorld(new Factory());
            counter.putScore(0);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }

}