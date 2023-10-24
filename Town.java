import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Town extends Main
{
    public boolean up = false;
    public boolean down = false;
    private boolean zero = false;
    private boolean fteen = false;
    private boolean isCute = false;
    private int lastDialogue;
    private int startPortal = 0;
    private int diff_up = 0;
    private int diff_down = 0;
    private int count = 0;
    
    Cuteintown cute = new Cuteintown();
    Coolintown cool = new Coolintown();
    PortalB portalb = new PortalB();
    DialogueTown1 dialogue = new DialogueTown1();
    DialogueTown2 dialogue2 = new DialogueTown2();
    
    public Town()
    {
        super();
        backgroundImage = new GreenfootImage("bege3.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare()
    {   
        Blocktown block1 = new Blocktown();
        addObject(block1, 300, 203);
        Blocktown block2 = new Blocktown();
        addObject(block2, 300, 376);
        
        addObject(counter, 75, 40);
        addObject(energy, 515, 40);
        
        addObject(portalb, 1, 131);
    }

    public void act(){
        super.act();
        
        int a = 100;
        if (timer == 1) {
            portalb.soundClose();
        }
        
        if (timer == 1) {
            backsound = new GreenfootSound("gamesound3.mp3");
            backsound.setVolume(5);
            backsound.play();
        } else if (timer == 10) {
            backsound.setVolume(15);
        } else if (timer == 15) {
            backsound.setVolume(25);
        } else if (timer == 25) {
            backsound.setVolume(35);
        } else if (timer == 35) {
            backsound.setVolume(45);
        } else if (timer == 50) {
            backsound.setVolume(55);
        } else if (timer == 65) {
            backsound.setVolume(65);
        }
        
        if(timer == 60){
            addObject(cute, 55, 132);
            addObject(dialogue, 300, 80);
            lastDialogue = timer;
            zero = true;
            isCute = true;
            dialogue.soundDialogue();
        }
        
        if (portalb.getX() == 0) {
            addObject(cool, 0, 132);
            
        }
        
        if (zero == true && count < 3) {
            if ((timer-lastDialogue) == 170) {
                dialogue.next();
                lastDialogue = timer;
                count++;
            }
        }
        
        if (energy.energy < 15) {
            /*if (timer % (a + 600) == 0){ //a nya 100 biar habis truct ada kucing
                addObject(new ObstacleCat(), 600, 325);
            } */
        
            if (timer % 300 == 0) {
                addObject(new ObstacleSubSurf(), 600, 167);
                addObject(new ObstacleSubSurf(), 600, 342);
            }
            
            if (timer % 600 == 0) {
                addObject(new ObstacleTruck(), 600, 310);
            }
            
            if (timer % 1100 == 0) {
                addObject(new ObstacleTruck(), 600, 138);
            }
            
            if (timer % 500 == 0) {
                addObject(new ObstacleMouse(), 0, 174);
            }
            
            if(timer % 200 == 0){
                addObject(new Drink(), 600, 337);
                addObject(new Drink(), 600, 163);
            }
            
            if (cool != null && timer > 300 && (timer % 300 == 90)) {
                cool.jump();
            }
        } else if (energy.energy == 5 && fteen == false) {
            addObject(dialogue2, 300, 80);
            lastDialogue = timer;
            fteen = true;
            dialogue2.soundDialogue();
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }     
        
        if (isCute == true && Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
        
        if(isCute == true &&Greenfoot.isKeyDown("up") && cute.isOnGround() && cute.getY() == 327 && 
            cute.getX() == 200){
            cute.kecepatan = -20;
            up = true;
            diff_up = timer;
            soundSwap();
        }
        
        if(isCute == true && Greenfoot.isKeyDown("down") && cute.isOnGround() && cute.getY() == 153 && 
            cute.getX() == 200){
            cute.falling = true;
            cute.kecepatan = 20;
            down = true;
            diff_down = timer;
            soundSwap();
        }
        
        
        if (isCute == true && up && (timer-diff_up) > 10 && cool.isOnGround()) {
            cool.kecepatan = -20;
            up = false;
        } 
        
        if (isCute == true && down && (timer-diff_down) > 10 && cool.isOnGround()) {
            cool.falling = true;
            cool.kecepatan = 20;
            down = false;
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
            backsound.stop();
        }
    }
}