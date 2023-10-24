import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialogue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueCave1 extends Dialogue
{
    GreenfootImage dialogue[] = new GreenfootImage[4];
    public int currentDialogue = 1;
    
    public DialogueCave1() {
        insertImage();
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void insertImage() {
        for (int i = 0; i < 3; i++) {
            int a = 11+i;
            String filename = "dialogue" + a + ".png";
            dialogue[i] = new GreenfootImage(filename);
        }
        dialogue[3] = new GreenfootImage("transparan.png");
    }
    
    public void next() {
        setImage(dialogue[currentDialogue++]);
    }
}
