import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueWin extends Dialogue
{
    GreenfootImage dialogue[] = new GreenfootImage[2];
    public int currentDialogue = 1;
    
    public DialogueWin() {
        insertImage();
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void insertImage() {
        for (int i = 0; i < 1; i++) {
            int a = 18+i;
            String filename = "dialogue" + a + ".png";
            dialogue[i] = new GreenfootImage(filename);
        }
        dialogue[1] = new GreenfootImage("transparan.png");
    }
    
    public void next() {
        setImage(dialogue[currentDialogue++]);
    }
}
