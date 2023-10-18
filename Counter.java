import greenfoot.*;  
import java.awt.Color;
import java.io.*;

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
        getScore();
        setImage(new GreenfootImage("Score : " + score, 30, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK));
    }
    
    public void addScore(){
        score++;
        putScore(score);
    }
    
    public void getScore(){
        try {
            FileInputStream fis = new FileInputStream("counter.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            score = (int) ois.readObject();
            ois.close();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void putScore(int val){
        try {
            FileOutputStream fos = new FileOutputStream("counter.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(val);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
