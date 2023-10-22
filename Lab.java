import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lab extends Main
{
    private boolean up = false;
    private boolean down = false;
    private int diff_up = 0;
    private int diff_down = 0;
    
    Cuteinlab cute = new Cuteinlab();
    Coolinlab cool = new Coolinlab();
    
    public Lab()
    {
        super();
        backgroundImage = new GreenfootImage("bege.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare(){
        Block block1 = new Block();
        addObject(block1, 300, 203);
        Block block2 = new Block();
        addObject(block2, 300, 376);
        
        addObject(cute, 0, 327);
    }
    
    public void act(){
        super.act();
        
        if (timer == 5) {
            backSound = new GreenfootSound("gamesound1.mp3");
            backSound.setVolume(60);
            backSound.play();
        }
        
        if (energy.energy < 5 ) {
            if(timer % 300 == 0 ){
                addObject(new Dot(), 600, 330);
                addObject(new Dot(), 600, 155);
                addObject(new Obstacle(), 600, 340);
                addObject(new Obstacle(), 600, 167);
            }
            
            if(timer % 200 == 0){
                addObject(new Drink(), 600, 337 );   
            }
            
            if (timer > 300 && timer % 300 == 90) {
                cool.jump();
            }
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if(cute.getX() == 199){
            addObject(cool,-50,324);
        }
        
        if (Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
        
        if(Greenfoot.isKeyDown("up") && cute.isOnGround() && cute.getY() == 327 && 
            cute.getX() == 200){
            cute.kecepatan = -20;
            up = true;
            diff_up = timer;
        }
        
        if(Greenfoot.isKeyDown("down") && cute.isOnGround() && cute.getY() == 153 && 
            cute.getX() == 200){
            cute.falling = true;
            cute.kecepatan = 20;
            down = true;
            diff_down = timer;
        }
        
        
        if (up && (timer-diff_up) > 10 && cool.isOnGround()) {
            cool.kecepatan = -20;
            up = false;
        } 
        
        if (down && (timer-diff_down) > 10 && cool.isOnGround()) {
            cool.falling = true;
            cool.kecepatan = 20;
            down = false;
        }
    }
}
