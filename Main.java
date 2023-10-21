import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Main extends World
{

    public GreenfootImage backgroundImage;
    public int scrollSpeed = 1;
    public int scrollPosition = 0;
    public GreenfootSound backgroundJump;
    public GreenfootSound backgroundSound;
    
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
        prepare();
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
        backgroundJump = new GreenfootSound("jump1.mp3");
        backgroundJump.play();
    }
    
    private void prepare()
    {
        addObject(counter, 75, 40);
        addObject(energy, 515, 40);
        
        
    }
    
    public void act(){
        timer++;
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}
