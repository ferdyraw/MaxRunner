import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    int time = 0;
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
        addObject(portalb, -35, 229);
        
    }
    public void act(){
        time++;
        if(time == 85){
            addObject(new Cuteincave(), 55, 229);
        }
    }
}
