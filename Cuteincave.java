import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinfactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuteincave extends Cute
{
    /**
     * Act - do whatever the Cuteinfactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cuteincave() {
        super();
    }
    
    public void act()
    {
        // Add your action code here.
        fall();
        out();
        
        if(Greenfoot.isKeyDown("space") && isOnGround()) {
            jump();
        }
        
        if(getOneIntersectingObject(Dot2.class) != null){
            Greenfoot.setWorld(new gameOver());
        }
        
        if(getOneIntersectingObject(ObstacleLava.class) != null){
            Greenfoot.setWorld(new gameOver());
        }
        
        if(getOneIntersectingObject(PortalD.class) != null){
            Greenfoot.setWorld(new Town());
        
        }
        
        addScore();
        addDrink();
        if(isOnGround()) Running();
        else Jumping(); 
    }
    
    public void fall(){
        setLocation(getX(), getY() + kecepatan);
        if (isOnGround()) {
            kecepatan = 0;
            if (falling == true) falling = false;
        } else {
            if (falling == true) kecepatan -= gravitasi;
            else kecepatan += gravitasi;
        }
        
    }
    
    public void jump(){
        kecepatan = -13;
    }
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 250) isOnGround = true;
        
        return isOnGround;            
    }
    
    public void addScore(){
        World myWorld = getWorld();
        Main bg = (Main)myWorld;
        Energy energy = bg.getEnergy();
        
        score++;
        if (score % 5 == 0 && energy.energy < 10){
            
            Counter counter = bg.getCounter();
            counter.addScore();
        }
    }
    
    public void addDrink(){
        Actor drink = getOneIntersectingObject(Drink.class);
        World myWorld = getWorld();
        
        if (drink != null){    
            myWorld.removeObject(drink);
            
            backSoundCoin = new GreenfootSound("koin.mp3"); //
            backSoundCoin.play();
            
            Main bg = (Main)myWorld;
            Energy energy = bg.getEnergy();
            energy.addEnergy();
            
            if (energy.energy == 10) {
                myWorld.addObject(new PortalD(),600,279); 
                num = 1;
                
            }
            
             
        }
    }
}
