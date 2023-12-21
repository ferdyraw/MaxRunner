import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuteinfactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuteintown extends Cute
{
    private boolean inPortal = false;
    public boolean puff = false;
    public boolean startPortal = false;
    private int sound = -1;
    
    /**
     * Act - do whatever the Cuteinfactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cuteintown() {
        super();
    }
    
    public void act()
    {
        // Add your action code here.
        fall();
        out();
        
        if(getOneIntersectingObject(ObstacleTruck.class) != null){
            World myWorld = getWorld();
            Town bg = (Town) myWorld;
            if (bg.backsound != null) bg.backsound.stop();
            Greenfoot.setWorld(new gameOver());
        }
        
        if (getOneIntersectingObject(ObstacleSubSurf.class) != null) {
            World myWorld = getWorld();
            Town bg = (Town) myWorld;
            if (bg.backsound != null) bg.backsound.stop();
            Greenfoot.setWorld(new gameOver());
        }
        
        if (getOneIntersectingObject(ObstacleMouse.class) != null) {
            World myWorld = getWorld();
            Town bg = (Town) myWorld;
            if (bg.backsound != null) bg.backsound.stop();
            Greenfoot.setWorld(new gameOver());
        }
        
        if (getOneIntersectingObject(PortalD.class) != null)  {
            puff = true;
            World myWorld = getWorld();
            Town bg = (Town) myWorld;
            bg.backsound.stop();
            Greenfoot.setWorld(new gameWin());
        }
        
        if (!inPortal) addScore();
        addDrink();
        if(isOnGround()) {
            Running();
            countJump = 0;
            countJump1 = 0;
        }
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
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 327 || 
        getY() == 153) isOnGround = true;
        
        return isOnGround;            
    }
    
    public void addDrink(){
        Actor drink = getOneIntersectingObject(Drink.class);
        World myWorld = getWorld();
        
        if (drink != null){    
            myWorld.removeObject(drink);
            
            if (sound == -1 && UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                sound = myInfo.getInt(2);
                
            }
            
            if (sound > 0) {
                backSoundCoin = new GreenfootSound("getPower1.mp3");
                backSoundCoin.setVolume(40-(10*(3-sound)));
                backSoundCoin.play();
            }
            
            Town bg = (Town)myWorld;
            Energy energy = bg.getEnergy();
            energy.addEnergy();
            
            if (energy.energy == 15) {
                PortalD portal = new PortalD();
                if (bg.up == true) {
                    myWorld.addObject(portal, 600, 105);
                } else if (bg.down == true) {
                    myWorld.addObject(portal, 600,279); 
                } else if (getY() >= 277 && getY() <= 327) {
                    myWorld.addObject(portal, 600,279); 
                } else if (getY() >= 103 && getY() <= 153) {
                    myWorld.addObject(portal, 600, 105);
                }
                portal.soundOpen();
                startPortal = true;
                num = 1;
                
            }
        }
    }
}
