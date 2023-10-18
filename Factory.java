import greenfoot.*;  


public class Factory extends World
{
    private GreenfootImage backgroundImage;
    private int scrollSpeed = 1;
    private int scrollPosition = 0;
    
    Counter counter = new Counter();
    Energy energy = new Energy();
    Highscore highscore = new Highscore();
    
    private int timer = 0;
    private void paint(int position)
    {
        getBackground().drawImage(backgroundImage, position - backgroundImage.getWidth(), 0);
        getBackground().drawImage(backgroundImage, position, 0);
    }
    public Factory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        backgroundImage = new GreenfootImage("bege.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    public Counter getCounter(){
        return counter;        
    }
    
    public Energy getEnergy(){
        return energy;
    }
    
    public Highscore getHighscore() {
        return highscore;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(counter, 75, 40);
        addObject(energy, 500, 40);

        Block block1 = new Block();
        addObject(block1,300 , 203);
        Block block2 = new Block();
        addObject(block2, 300, 376);

        Cute cute = new Cute();
        addObject(cute,111,327);
        
    }
    
    public void act(){
        timer++;
        
        if(timer % 300 == 0 ){
            addObject(new Dot(), 600, 330);
            addObject(new Dot(), 600, 155);
            addObject(new Obstacle(), 600, 340);
            addObject(new Obstacle(), 600, 167);
        }
        if(timer % 200 == 0){
            addObject(new Drink(), 600, 340);
            
        }
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        

        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }   
}
