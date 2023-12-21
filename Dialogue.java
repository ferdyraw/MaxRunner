import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue extends Actor
{
    public GreenfootSound backsoundDialogue;
    private int sound = -1;
    /**
     * Act - do whatever the Dialogue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void soundDialogue() {
        if (sound == -1 && UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo(); 
            sound = myInfo.getInt(2);
        }
        
        if (sound > 0) {
            backsoundDialogue = new GreenfootSound("dialogue3.mp3");
            backsoundDialogue.setVolume(65-(20*(3-sound)));
            backsoundDialogue.play();
        }
        
    }
}
