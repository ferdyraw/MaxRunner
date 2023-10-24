import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ObstacleCat extends Obstacle
{
    private int frame = 0;
    private GreenfootImage[] animationFrames = new GreenfootImage[6];
  
    public ObstacleCat()
    {
        for (int i = 0; i < 6; i++){
            animationFrames[i] = new GreenfootImage("Walk_" + (i + 1)+".png");
            animationFrames[i].scale(50, 60);
        
        }
    }
    
    public void act()
    {
        setImage(animationFrames[frame]);
        frame = (frame + 1) % 6;
        
        move(-6);
    }
}
