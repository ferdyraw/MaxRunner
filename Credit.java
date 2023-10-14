import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credit extends Button
{
    public Credit(){
        GreenfootImage creditButton = new GreenfootImage(200,120);
        Font adjustedFont = new Font(true, false, 50);
        creditButton.setFont(adjustedFont);
        creditButton.setColor(Color.BLACK);
        creditButton.drawString("Credit", 0, 50);
        setImage(creditButton);
    }
    public void act()
    {
        checkMouse();
    }
}
