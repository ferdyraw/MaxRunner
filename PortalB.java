import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PortalB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalB extends Actor
{
    
    private GreenfootImage[] imagesPortal= new GreenfootImage[8];
    private int countPortal = 0;
    private int num = 1;
    private int timer = 0;
    private int countPortal1 = 0;
    public PortalB(){
        animPortal();
    }
    public void act()
    {
        Anim();
        walk();
        
    }
    public void animPortal(){
        for(int i = 0; i < 8; i++){
            int a = i+1;
            String filename = "portal"+ a + "_b.png";
            imagesPortal[i] = new GreenfootImage(filename);   
        } 
    }
    public void Anim(){
        
        if(countPortal1 % 4 == 0 ){
        setImage(imagesPortal[countPortal++ %8]);
        
        }
        if(countPortal1 > 32){
            countPortal1 = 0;
        }
        countPortal1 ++;
    }
    public void walk(){
        timer++;
        setLocation(getX() + num, getY());
        if(getX() == 55){
            num = 0;
            
        }
<<<<<<< HEAD
        if(timer == 270){
=======
        if(timer == 180){
>>>>>>> c0fd9905bccb09ad5e231eefdb5026451301fea0
            num = -1;
        }
    }
}
