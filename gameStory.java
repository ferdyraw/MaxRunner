import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameStory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameStory extends World
{

    /**
     * Constructor for objects of class gameStory.
     * 
     */
    
    private int timer = 0;
    public gameStory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        prepare();
    }
    public void prepare(){
        Blockstory block = new Blockstory();
        addObject(block, 300, 376);
        
        addObject(new Cuteinstory(), 300, 327);
    }
    public void act(){
        timer ++;
        if(timer == 100){
            addObject(new Coolinstory(), 0, 327);
        }
    }
}
