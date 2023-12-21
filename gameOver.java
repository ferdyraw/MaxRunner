import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends World
{
    public GreenfootSound backgroundSound;
    private int sound = 0;
    
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
        
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
                
            sound = myInfo.getInt(2);
            if (sound > 0) {
                backgroundSound = new GreenfootSound("gameover1.mp3");
                backgroundSound.setVolume(backgroundSound.getVolume()-(20*(3-sound)));
                backgroundSound.play();
            }
        }
    }
    
    public void act(){
        

        if(Greenfoot.isKeyDown("R")){
            Greenfoot.setWorld(new Lab());
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }

}