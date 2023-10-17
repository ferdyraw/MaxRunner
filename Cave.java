import greenfoot.*;  


public class Cave extends World
{
    private GreenfootImage backgroundImage;
    private int scrollSpeed = 1;
    private int scrollPosition = 0;
    
    Counter counter = new Counter();
    Highscore highscore = new Highscore();
    
    private int timer = 0;
    private void paint(int position)
    {
        getBackground().drawImage(backgroundImage, position - backgroundImage.getWidth(), 0);
        getBackground().drawImage(backgroundImage, position, 0);
    }
    public Cave()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        backgroundImage = new GreenfootImage("bege2.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    public Counter getCounter(){
        return counter;        
    }
    
    public Highscore getHighscore(){
        return highscore;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        PortalB portalB = new PortalB();
        addObject(portalB,55,229);
    }
    
    public void act(){
        timer++;
        
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if(Greenfoot.isKeyDown("E")){
            Greenfoot.setWorld(new gameMenu());
        }
        
    }
}
