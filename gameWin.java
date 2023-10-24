import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameWin extends World
{
    private GreenfootImage backgroundImage;
    private int timer = 0;
    
    Highscore highscore = new Highscore();
    Counter counter = new Counter();
    PortalB portal = new PortalB();
    
    public gameWin()
    {    
        super(600, 400, 1, false); 
        backgroundImage = new GreenfootImage("bege4.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    public void prepare(){
        counter.getScore();
        highscore.putScore(counter.score);
        addObject(highscore, 300, 100);
        
        addObject(new Blockwin(), 300, 350);
        addObject(portal, 1, 250);
    }
    
    public void act(){
        timer++;
        
        if (timer == 1) {
            portal.soundClose();
        }
        
        if (timer == 60) {
            addObject(new Cuteinwin(), 55, 250);
        }

        if(Greenfoot.isKeyDown("R")){
            Greenfoot.setWorld(new Lab());
            counter.putScore(0);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }

}