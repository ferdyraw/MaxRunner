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
        Block block1 = new Block();
        addObject(block1, 300, 280);
        
        PortalB portalb = new PortalB();
        addObject(portalb, 55, 229);
        
        Cuteincave cute = new Cuteincave();
        addObject(cute, 111, 229);
    }
}
