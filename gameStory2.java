import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameStory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameStory2 extends World
{   
    private GreenfootSound backsoundGate;
    public int timer = 0;
    public int lastDialogue;
    
    Cuteinstory cute = new Cuteinstory();
    Coolinstory cool = new Coolinstory();
    Entry entry = new Entry();
    DialogueStory2 dialogue = new DialogueStory2();
    
    public gameStory2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
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
        
        if (timer == 50){
            addObject(cool, 0, 324);
        }
        
        if (timer == 110) {
            backsoundGate = new GreenfootSound("gate_open.mp3");
            backsoundGate.setVolume(80);
            backsoundGate.play();
        }
        
        if (timer == 115) {
            addObject(dialogue, 300, 80);
            dialogue.soundDialogue();
        }
        
        for (int i = 0; i < 5; i++) {
            if (timer == 315+i*200) {
                dialogue.next();
            }
        }
        
        for (int i = 0; i < 25; i++) {
            int j = i/5;
            if (timer >= 90+(j*5) && timer < 90+((j+1)*5)) {
                entry.Open(j);
            }
        }
    
        for (int i = 0; i < 20; i++) {
            int j = i/5;
            if (timer >= 250+(j*5) && timer < 250+((j+1)*5)) {
                entry.Close(j);
            }
        }
    }
}
