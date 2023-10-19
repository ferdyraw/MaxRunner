import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lava extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] imagesLava = new GreenfootImage[10];
    private int count = 0;
    private int countBlock = 0;
    public Lava(){
        animLava();
    }
    public void act()
    {
        // Add your action code here.
        ground();
    }
    public void animLava(){
       for(int i = 0; i < 10; i++){
            int a = i+1;
            String filename = "blockcave"+ a + ".png";
            imagesLava[i] = new GreenfootImage(filename);   
            
        } 
    }
    public void ground(){
        if(countBlock % 6 == 0 ){
        setImage(imagesLava[count++ %10]);
        
        }
        if(countBlock > 36){
            countBlock = 0;
        }
        countBlock ++;
    }
}
