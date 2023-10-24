import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueStory2 extends Dialogue
{
    GreenfootImage dialogue[] = new GreenfootImage[6];
    public int currentDialogue = 1;
    
    public DialogueStory2() {
        insertImage();
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void insertImage() {
        for (int i = 0; i < 6; i++) {
            int a = 3+i;
            String filename = "dialogue" + a + ".png";
            dialogue[i] = new GreenfootImage(filename);
        }
    }
    
    public void next() {
        setImage(dialogue[currentDialogue++]);
        soundDialogue();
    }
}
