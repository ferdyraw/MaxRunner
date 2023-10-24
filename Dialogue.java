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
    /**
     * Act - do whatever the Dialogue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void soundDialogue() {
        backsoundDialogue = new GreenfootSound("dialogue.mp3");
        backsoundDialogue.setVolume(45);
        backsoundDialogue.play();
    }
}
