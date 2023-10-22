import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstacleMouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleMouse extends Obstacle
{
    private GreenfootImage[] imagesMouse = new GreenfootImage[4];
    private int countRun = 0;
    private int countRun1 = 0;
    
    public ObstacleMouse() {
        animMouse();
    }
    
    public void act()
    {
        // Add your action code here.
        move(5);
        Running();
    }
    
    public void animMouse() {
        for (int i = 0; i < 4; i++) {
            int a = i+1;
            String filename = "mouse" + a + ".png";
            imagesMouse[i] = new GreenfootImage(filename);
        }
    }
    
    public void Running() {
        if(countRun1 % 5 == 0 ){
        setImage(imagesMouse[countRun++ %4]);
        
        }
        if(countRun1 > 20){
            countRun1 = 0;
        }
        countRun1 ++;
    }
}
