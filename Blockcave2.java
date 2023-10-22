import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blockcave2 extends Block
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] imagesLava = new GreenfootImage[10];
    private int count = 0;
    private int countBlock = 0;
    
    public Blockcave2(){
        animLava();
    }
    public void act()
    {
        // Add your action code here.
        ground();
    }
    public void animLava(){
       int a = 6; 
       for (int i = 0; i < 10; i++) {
           if (a == 0) a = 10;
           String filename = "blockcave"+ a-- + " - Copy.png";
           imagesLava[i] = new GreenfootImage(filename);
       }   
    }
    public void ground(){
        if(countBlock % 6 == 0 ){
        setImage(imagesLava[count++ %10]);
        
        }
        if(countBlock > 60){
            countBlock = 0;
        }
        countBlock ++;
    }
}
