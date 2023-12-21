import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Main extends World
{
    public GreenfootSound backsound;
    public GreenfootImage backgroundImage;
    public int scrollSpeed = 1;
    public int scrollPosition = 0;
    public GreenfootSound backSoundJump;
    public GreenfootSound backSoundSwap;
    private int soundJump = -1;
    private int soundSwap = -1;
    
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
        if (soundJump == -1 && UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();   
            soundJump = myInfo.getInt(2);
        }
        
        if (soundJump > 0) {
            backSoundJump = new GreenfootSound("jump1.mp3");
            backSoundJump.setVolume(40-(10*(3-soundJump)));
            backSoundJump.play();
        }
    }
    
    public void soundSwap() {
        if (soundSwap == -1 && UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();   
            soundSwap = myInfo.getInt(2);
        }
        
        if (soundSwap > 0) {
            backSoundSwap = new GreenfootSound("sound_swap.mp3");
            backSoundSwap.setVolume(30-(10*(3-soundSwap)));
            backSoundSwap.play();
        }
    }
    
    public void act(){
        timer++;
        
        
    }
}
