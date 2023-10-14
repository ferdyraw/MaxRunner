import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private GreenfootImage[] imagesCoin= new GreenfootImage[10];
    /**
     * Act - do whatever the coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int countCoin = 0;
    public Coin(){
        animCoin();
    }
    public void act()
    {
        Anim();
        move(-5);
        // Add your action code here.
    }
    
    public void animCoin(){
        for(int i = 0; i < 10; i++){
            int a = i+1;
            String filename = "coin"+ a + ".png";
            imagesCoin[i] = new GreenfootImage(filename);   
        } 
    }
    public void Anim(){
        setImage(imagesCoin[countCoin++ %10]);
    }
}
