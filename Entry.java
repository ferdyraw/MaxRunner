import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entry extends Actor
{
    private GreenfootImage[] imagesGateOpen= new GreenfootImage[5];
    private GreenfootImage[] imagesGateClose= new GreenfootImage[4];
    
    

    public Entry()
    { 
        animGate();
    }
    public void act() 
    {
        
    }    
    public void animGate(){
        for(int i = 0; i < 5; i++){
            int a = i+1;
            String filename = "EntryOpen_"+ a + ".png";
            imagesGateOpen[i] = new GreenfootImage(filename);   
        } 
        for(int i = 0; i < 4; i++){
            int a = i+1;
            String filename = "EntryClose_"+ a + ".png";
            imagesGateClose[i] = new GreenfootImage(filename);   
        } 
    }
    public void Open(){
        for(int i  = 0; i < 5; i++){
            setImage(imagesGateOpen[i]);
        }
    }
    public void Close(){
        for(int i  = 0; i < 4; i++){
            setImage(imagesGateClose[i]);
        }
    }
}
