import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    public Cave()
    {
        super();
        backgroundImage = new GreenfootImage("bege2.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare()
    {   
        Lava lava = new Lava();
        addObject(lava, 300,335);
        
        PortalB portalb = new PortalB();
        addObject(portalb, -35, 184);
        
        Coolincave cool = new Coolincave();
        addObject(cool, 300, 184);
        
    }
    public void act(){
        super.act();
        if(timer == 85){
            addObject(new Cuteincave(), 55, 184);
        }
        
        if (timer % 400 == 0){
            addObject(new Dot2(), 600, 112);
            addObject(new Obstacle2(), 600, 122);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}
