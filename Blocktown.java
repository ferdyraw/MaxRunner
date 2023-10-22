import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blocktown extends Block
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] imagesBlock= new GreenfootImage[11];
    private int count = 0;
    private int countBlock = 0;
    public Blocktown(){
        animBlock();
    }
    public void act()
    {
        // Add your action code here.
        ground();
    }
    public void animBlock(){
       for(int i = 0; i < 11; i++){
            int a = i+1;
            String filename = "road"+ a + ".png";
            imagesBlock[i] = new GreenfootImage(filename);   
        } 
    }
    public void ground(){
        if(countBlock % 6 == 0 ){
        setImage(imagesBlock[count++ %10]);
        
        }
        if(countBlock > 60){
            countBlock = 0;
        }
        countBlock ++;
    }
}
