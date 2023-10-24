import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lab extends Main
{
    public boolean up = false;
    public boolean down = false;
    public boolean five = false;
    private int diff_up = 0;
    private int diff_down = 0;
    private int lastDialogue;
    private int startPortal = 0;
    
    Cuteinlab cute = new Cuteinlab();
    Coolinlab cool = new Coolinlab();
    DialogueLab dialogue = new DialogueLab();
    
    public Lab()
    {
        super();
        backgroundImage = new GreenfootImage("bege.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare(){
        Blocklab block1 = new Blocklab();
        addObject(block1, 300, 203);
        Blocklab block2 = new Blocklab();
        addObject(block2, 300, 376);
        
        addObject(counter, 75, 40);
        addObject(energy, 515, 40);
        
        addObject(cute, 0, 327);
    }
    
    public void act(){
        super.act();
        
        if (timer == 5) {
            backsound = new GreenfootSound("gamesound1.mp3");
            backsound.setVolume(65);
            backsound.playLoop();
        }
            
        if (energy.energy < 5 ) {
            if(timer % 300 == 0 ){
                addObject(new Dot(), 600, 330);
                addObject(new Dot(), 600, 155);
                addObject(new ObstacleCone(), 600, 340);
                addObject(new ObstacleCone(), 600, 167);
            }
            
            if(timer % 200 == 0){
                addObject(new Drink(), 600, 337 );   
            }
            
            if (cool != null && timer > 300 && timer % 300 == 90) {
                cool.jump();
                soundJump();
            }
        } else if (energy.energy == 5 && five == false) {
            five = true;
            lastDialogue = timer;
            addObject(dialogue, 300, 80);
            dialogue.soundDialogue();
        }
        
        if (five && (timer-lastDialogue) == 150) {
            dialogue.next();
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if(cute != null && cute.getX() == 199){
            addObject(cool,-50,324);
        }
        
        if (cute != null && Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
        
        if(cute != null && Greenfoot.isKeyDown("up") && cute.isOnGround() && cute.getY() == 327 && 
            cute.getX() == 200){
            cute.kecepatan = -20;
            up = true;
            soundSwap();
            diff_up = timer;
            soundSwap();
        }
        
        if(cute != null && Greenfoot.isKeyDown("down") && cute.isOnGround() && cute.getY() == 153 && 
            cute.getX() == 200){
            cute.falling = true;
            cute.kecepatan = 20;
            down = true;
            soundSwap();
            diff_down = timer;
            soundSwap();
        }
        
        
        if (cool != null && up && (timer-diff_up) > 10 && cool.isOnGround()) {
            cool.kecepatan = -20;
            up = false;
        } 
        
        if (cool != null && down && (timer-diff_down) > 10 && cool.isOnGround()) {
            cool.falling = true;
            cool.kecepatan = 20;
            down = false;
        }
        
        if (cute != null && cute.startPortal == true) {
            if (startPortal == 0) {
                startPortal = timer;
            } else if (timer-startPortal == 40) {
                backsound.setVolume(60);
            } else if (timer-startPortal == 80) {
                backsound.setVolume(50);
            } else if (timer-startPortal == 120) {
                backsound.setVolume(40);
            } else if (timer-startPortal == 180) {
                backsound.setVolume(30);
            } else if (timer-startPortal == 210) {
                backsound.setVolume(20);
            } else if (timer-startPortal == 230) {
                backsound.setVolume(10);
            } else if (timer-startPortal == 250) {
                backsound.setVolume(5);
            }
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
            backsound.stop();
        }
        
    }
}
