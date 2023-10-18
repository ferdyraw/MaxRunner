import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    public Cave()
    {
        backgroundImage = new GreenfootImage("bege2.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare()
    {
        PortalB portalb = new PortalB();
        addObject(portalb, 55, 229);
        
        
        addObject(cute, 111, 327);
    }
}
