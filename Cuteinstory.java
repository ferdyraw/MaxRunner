import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinstory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuteinstory extends Cute
{
    /**
     * Act - do whatever the Cuteinstory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int num = 0;
    private boolean idle = true;
    private int timer = 0;
    public void act()
    {
        timer++;
        setLocation(getX() + num, getY());
        if(timer == 800){
            num = 3;
            idle = false;
        }
        run();
    }
    public void run(){
        if(!idle){
            Running();
        }else Idle();
    }
}
