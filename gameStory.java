import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameStory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameStory extends World
{   
    private GreenfootSound backsoundGate;
    public int timer = 0;
    public int lastDialogue;
    
    Cuteinstory cute = new Cuteinstory();
    Coolinstory cool = new Coolinstory();
    Entry entry = new Entry();
    DialogueStory1 dialogue = new DialogueStory1();
    
    public gameStory()
    {    
        super(600, 400, 1, false);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        
        prepare();
    }
    
    public void prepare(){
        Blockstory block = new Blockstory();
        addObject(block, 300, 376);

        addObject(cute, 500, 327);
        addObject(entry,244,321);
    }

    public void act(){
        timer ++;
       
        
        if (timer == 100) {
            addObject(dialogue, 300, 80);
            dialogue.soundDialogue();
        }
        
        for (int i = 0; i < 1; i++) {
            if (timer == 300+i*200) {
                dialogue.next();
            }
        }
        
        if (timer == 450) {
            Greenfoot.setWorld(new gameStory2());
        }
        
        if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(new gameMenu());
        }
        
        if (Greenfoot.isKeyDown("N")) {
            Greenfoot.setWorld(new Lab());
        }
    }
}
