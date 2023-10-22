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
    
    Cuteinstory cute = new Cuteinstory();
    Coolinstory cool = new Coolinstory();
    Entry entry = new Entry();
    
    public gameStory()
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
        
        if (timer == 100){
            addObject(cool, 0, 324);
        }
        
        if (timer == 160) {
            backsoundGate = new GreenfootSound("gate_open.mp3");
            backsoundGate.setVolume(80);
            backsoundGate.play();
        }
        
        for (int i = 0; i < 25; i++) {
            int j = i/5;
            if (timer >= 140+(j*5) && timer < 140+((j+1)*5)) {
                entry.Open(j);
            }
        }
    
        for (int i = 0; i < 20; i++) {
            int j = i/5;
            if (timer >= 300+(j*5) && timer < 300+((j+1)*5)) {
                entry.Close(j);
            }
        }
    }
}
