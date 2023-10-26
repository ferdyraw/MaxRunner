import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    private boolean zero = false;
    private boolean ten = false;
    private boolean isCute = false;
    private int lastDialogue;
    private int startPortal = 0;
    private int count = 0;
    
    Cuteincave cute = new Cuteincave();
    Coolincave cool = new Coolincave();
    PortalB portalb = new PortalB();
    DialogueCave1 dialogue = new DialogueCave1();
    DialogueCave2 dialogue2 = new DialogueCave2();
    
    public Cave()
    {
        super();
        backgroundImage = new GreenfootImage("bege2.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare()
    {   
        addObject(new Blockcave(), 300,335);
        addObject(new Blockcave2(), 300, 25);
        
        addObject(counter, 75, 40);
        addObject(energy, 515, 40);
        
        addObject(portalb, 1, 184);
    }
    public void act(){
        super.act();
        
        if (timer == 1) {
            portalb.soundClose();
        }
        
        if (timer == 1) {
            backsound = new GreenfootSound("gamesound2.mp3");
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
            addObject(cute, 55, 184);
            isCute = true;
        }
        
        if (portalb.getX() == 0) {
            addObject(cool, 0, 184);
            addObject(dialogue, 300, 80);
            dialogue.soundDialogue();
            lastDialogue = timer;
            zero = true;
        }
        
        if (zero == true && count < 3) {
            if ((timer-lastDialogue) == 200) {
                dialogue.next();
                lastDialogue = timer;
                count++;
            }
        }
        
        if (energy.energy < 10) {
            if (timer % 800 == 0){
                addObject(new Dot2(), 600, 79);
                addObject(new ObstacleDrop(), 600, 89);
            }
            
            if (timer % 350 == 0){
                addObject(new ObstacleLava(), 600, 302);
            }
            
            if (timer % 190 == 0) {
                addObject(new Drink(), 600, 260);
            }
            
            if (cool != null && timer > 350 && (timer % 350 == 85 || timer % 800 == 100)) {
                cool.jump();
            }
        } else if (energy.energy == 10 && ten == false) {
            addObject(dialogue2, 300, 80);
            dialogue2.soundDialogue();
            ten = true;
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if (isCute == true && Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
        
        if (isCute == true && cute.startPortal == true) {
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
        
        if(backsound != null && Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
            backsound.stop();
        }
        
        if (backsound != null && Greenfoot.isKeyDown("R")) {
            Greenfoot.setWorld(new Lab());
            backsound.stop();
        }
    }
}
