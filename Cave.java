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
        
        if (timer % 400 == 0){
            addObject(new Dot2(), 600, 112);
            addObject(new Obstacle2(), 600, 122);
        }
        
        if (timer % 350 == 0){
            addObject(new ObstacleLava(), 600, 304);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}
