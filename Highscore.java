import greenfoot.*;  
import java.awt.Color;
import java.io.*;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int minScore = Integer.MAX_VALUE;
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage("Best game : " + minScore + " score", 30, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK));
    }
    
    public void putScore(int score){
        minScore = Math.min(minScore, score);   
        try {
            FileOutputStream fos = new FileOutputStream("highscores.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(minScore);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void getScore(){
        try {
            FileInputStream fis = new FileInputStream("highscores.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            minScore = (int) ois.readObject();
            ois.close();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
