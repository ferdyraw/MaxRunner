import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lab extends Main
{
    public Lab()
    {
        super();
        backgroundImage = new GreenfootImage("bege.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare(){
        Block block1 = new Block();
        addObject(block1, 300, 203);
        Block block2 = new Block();
        addObject(block2, 300, 376);
        
<<<<<<< HEAD
        addObject(new Cuteinlab(), 0, 327);
=======

        addObject(new Cuteinlab(), 0, 327);

       

>>>>>>> 478cda74f363a16ba49031f7ed4a52ae590393d4
    }
    
    public void act(){
        super.act();
        if(timer % 300 == 0 ){
            addObject(new Dot(), 600, 330);
            addObject(new Dot(), 600, 155);
            addObject(new Obstacle(), 600, 340);
            addObject(new Obstacle(), 600, 167);
        }
        if(timer % 200 == 0){
            addObject(new Drink(), 600, 340);
            
        }
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}
