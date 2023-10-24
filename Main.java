import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Main extends World
{
    public GreenfootSound backsound;
    public GreenfootImage backgroundImage;
    public int scrollSpeed = 1;
    public int scrollPosition = 0;
    public GreenfootSound backSoundJump;
    public GreenfootSound backSoundSwap;
    
    Counter counter = new Counter();
    Energy energy = new Energy();
    Highscore highscore = new Highscore();
    
    public int timer = 0;
    public void paint(int position)
    {
        getBackground().drawImage(backgroundImage, position - backgroundImage.getWidth(), 0);
        getBackground().drawImage(backgroundImage, position, 0);
    }
    public Main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    public Energy getEnergy(){
        return energy;
    }
    
    public Highscore getHighscore(){
        return highscore;
    }
    
    public void soundJump() {
        backSoundJump = new GreenfootSound("jump1.mp3");
        backSoundJump.setVolume(40);
        backSoundJump.play();
    }
    
    public void soundSwap() {
        backSoundSwap = new GreenfootSound("sound_swap.mp3");
        backSoundSwap.setVolume(30);
        backSoundSwap.play();
    }
    
    public void act(){
        timer++;
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}
