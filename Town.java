import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Town extends Main
{
    Cuteincave cute = new Cuteincave();
    Coolincave cool = new Coolincave();
    PortalB portalb = new PortalB();
    
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
    }
    public void act(){
        super.act();
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }      
    }
}
