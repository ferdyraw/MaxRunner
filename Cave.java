import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    Cuteincave cute = new Cuteincave();
    Coolincave cool = new Coolincave();
    PortalB portalb = new PortalB();
    
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
        
        addObject(portalb, 1, 184);
        
        
    }
    public void act(){
        super.act();
        if(timer == 85){
            addObject(cute, 55, 184);
        }
        
        if (portalb.getX() == 0) {
            addObject(cool, 0, 184);
        }
        
        if (energy.energy < 10) {
            if (timer % 400 == 0){
                addObject(new Dot2(), 600, 100);
                addObject(new Obstacle2(), 600, 110);
            }
            
            if (timer % 350 == 0){
                addObject(new ObstacleLava(), 600, 302);
            }
            
            if (timer % 200 == 0) {
                addObject(new Drink(), 600, 260);
            }
            
            if (timer > 350 && (timer % 350 == 85 || timer % 400 == 100)) {
                cool.jump();
            }
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
        
        if (Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
    }
}
