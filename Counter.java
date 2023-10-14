import greenfoot.*;  
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int score = 0;
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage("Score : " + score, 30, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK));
    }
    public void addScore(){
        score++;
    }
}
