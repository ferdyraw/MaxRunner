import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueStory1 extends Dialogue
{
    GreenfootImage dialogue[] = new GreenfootImage[2];
    public int currentDialogue = 1;
    
    public DialogueStory1() {
        insertImage();
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void insertImage() {
        for (int i = 0; i < 2; i++) {
            int a = 1+i;
            String filename = "dialogue" + a + ".png";
            dialogue[i] = new GreenfootImage(filename);
        }
    }
    
    public void next() {
        setImage(dialogue[currentDialogue++]);
    }
}
