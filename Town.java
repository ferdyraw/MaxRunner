import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Town extends Main
{
    public boolean up = false;
    public boolean down = false;
    private boolean zero = false;
    private boolean fteen = false;
    private int lastDialogue;
    private int diff_up = 0;
    private int diff_down = 0;
    
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
        
        if(timer == 60){
            addObject(cute, 55, 132);
        }
        
        if (portalb.getX() == 0) {
            addObject(cool, 0, 132);
            addObject(dialogue, 300, 80);
            lastDialogue = timer;
            zero = true;
        }
        
        if (zero == true) {
            for (int i = 0; i < 4; i++) {
                if ((timer-lastDialogue) == 200) {
                    if (i < 3) {
                        dialogue.next();
                    } else {
                        removeObject(dialogue);
                    }
                    lastDialogue = timer;
                }
            }
        }
        
        if (energy.energy < 5) {
            if (timer % (a + 600) == 0){ //a nya 100 biar habis truct ada kucing
                addObject(new ObstacleWalk_1(), 600, 325);
            }
        
            if (timer % 300 == 0) {
                addObject(new ObstacleSubSurf(), 600, 163);
                addObject(new ObstacleSubSurf(), 600, 335);
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
            
            if (timer > 300 && timer % 300 == 90) {
                cool.jump();
            }
        } else if (energy.energy == 5 && fteen == false) {
            addObject(dialogue2, 300, 80);
            lastDialogue = timer;
            fteen = true;
        }
        
        
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
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
            soundSwap();
        }
        
        if(Greenfoot.isKeyDown("down") && cute.isOnGround() && cute.getY() == 153 && 
            cute.getX() == 200){
            cute.falling = true;
            cute.kecepatan = 20;
            down = true;
            diff_down = timer;
            soundSwap();
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