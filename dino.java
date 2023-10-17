import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dino extends Actor
{
    private GreenfootImage[] imagesRun= new GreenfootImage[8];
    private GreenfootImage[] imagesJump= new GreenfootImage[12];
    private int countRun= 0;
    private int countRun1 = 0;
    private int countJump = 0;
    private final int gravitasi = 1;
    private int kecepatan;
    private boolean falling = false;
    private GreenfootSound backSoundCoin;
    private int score = 0;
    /*
     * Act - do whatever the dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public dino(){
        animJump();
        animRun();
        kecepatan = 0;
    }
    public void act()
    {
        // Add your action code here.
        fall();
        
        if(Greenfoot.isKeyDown("space") && isOnGround()) {
            jump();
        }
    
        if(Greenfoot.isKeyDown("up") && isOnGround() && getY() == 332){
            kecepatan = -20;
        }else if(Greenfoot.isKeyDown("down") && isOnGround() && getY() == 158){
            falling = true;
            kecepatan = 20;
        }
        
        if(getOneIntersectingObject(Dot.class) != null){
            World myWorld = getWorld();
            gameBackground bg = (gameBackground)myWorld;
            Highscore highscore = bg.getHighscore();
            highscore.putScore(bg.getCounter().score);
            
            Greenfoot.setWorld(new gameOverBackground());
        }
        
        if(getOneIntersectingObject(PortalD.class) != null){
            Greenfoot.setWorld(new gameLevel2());
        
        }
        
        addScore();
        if(isOnGround()) Running();
        else Jumping(); 
    }
    public void Running(){
        if(countRun1 % 4 == 0 ){
        setImage(imagesRun[countRun++ %8]);
        
        }
        if(countRun1 > 32){
            countRun1 = 0;
        }
        countRun1 ++;
    }
    public void animRun(){
       for(int i = 0; i < 8; i++){
            int a = i+1;
            String filename = "Run"+ a + ".png";
            imagesRun[i] = new GreenfootImage(filename);   
        } 
    }
    public void animJump(){
        for(int i = 0; i < 12; i++){
            int a = i+1;
            String filename = "Jump"+ a + ".png";
            imagesJump[i] = new GreenfootImage(filename);   
        } 
        
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
    public void Jumping(){
        setImage(imagesJump[countJump++ %12]);
        
    }
    public void jump(){
        kecepatan = -13;
    }
    
    public boolean isOnGround(){
        boolean isOnGround = false;
        if(getY() == 332 || 
        getY() == 158) isOnGround = true;
        
        return isOnGround;
    }
    public void addScore(){
        Actor coin = getOneIntersectingObject(Coin.class);
        World myWorld = getWorld();
        
        if(coin != null){
            myWorld.removeObject(coin);
            World bg1 = getWorld();
            bg1.addObject(new PortalD(),600,279);           
            
            backSoundCoin = new GreenfootSound("koin.mp3"); //
            backSoundCoin.play();
        }
        score++;
        if(score % 5 == 0){
            gameBackground bg = (gameBackground)myWorld;
            Counter counter = bg.getCounter();
            counter.addScore();
        }
    }
}