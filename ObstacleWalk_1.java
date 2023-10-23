import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ObstacleWalk_1 extends Actor
{
    private int frame = 0;
    private GreenfootImage[] animationFrames = new GreenfootImage[6];
  
    public ObstacleWalk_1()
    {
        for (int i = 0; i < 6; i++){
            animationFrames[i] = new GreenfootImage("walk_" + (i + 1)+".png");
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
