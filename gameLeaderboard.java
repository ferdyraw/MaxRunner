import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameLeaderboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameLeaderboard extends World
{

    /**
     * Constructor for objects of class gameLeaderboard.
     * 
     */
    public gameLeaderboard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new ScoreBoard(), 300, 100);
    }
}
