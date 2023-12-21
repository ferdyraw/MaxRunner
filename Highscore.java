import greenfoot.*;  

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public UserInfo user;
    
    public Highscore() {
        user = UserInfo.getMyInfo();
    }
    
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage("Best game : " + user.getScore() + " score", 30, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK));
    }
    
    public void putScore(int score){
        int minScore = Math.min(user.getScore(), score);   
        if (user.isStorageAvailable()) {
            user.setScore(minScore);
            user.store();
        }
    }
}