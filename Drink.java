import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Drink extends Actor
{
    private GreenfootImage[] imagesDrink= new GreenfootImage[10];
    /**
     * Act - do whatever the coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int countDrink = 0;
    public Drink(){
        animDrink();
    }
    public void act()
    {
        Anim();
        move(-6);
        // Add your action code here.
    }
    
    public void animDrink(){
        for(int i = 0; i < 10; i++){
            int a = i+1;
            String filename = "coin"+ a + ".png";
            imagesDrink[i] = new GreenfootImage(filename);   
        } 
    }
    public void Anim(){
        setImage(imagesDrink[countDrink++ %10]);
    }
}
