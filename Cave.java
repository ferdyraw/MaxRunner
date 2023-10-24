import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    private boolean zero = false;
    private boolean ten = false;
    private int lastDialogue;
    
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
        
        if(timer == 60){
            addObject(cute, 55, 184);
        }
        
        if (portalb.getX() == 0) {
            addObject(cool, 0, 184);
            addObject(dialogue, 300, 80);
            lastDialogue = timer;
            zero = true;
        }
        
        if (zero == true) {
            for (int i = 0; i < 3; i++) {
                if ((timer-lastDialogue) == 200) {
                    dialogue.next();
                    lastDialogue = timer;
                }
            }
        }
        
        if (energy.energy < 5) {
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
            
            if (timer > 350 && (timer % 350 == 85 || timer % 400 == 100)) {
                cool.jump();
            }
        } else if (energy.energy == 5 && ten == false) {
            addObject(dialogue2, 300, 80);
            ten = true;
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if (Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
    }
}
