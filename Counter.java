import greenfoot.*;  

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public UserInfo user;
    public int fontsize = 30;
    
    public Counter() {
        user = UserInfo.getMyInfo();
    }
    
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage("Score : " + user.getInt(4), fontsize, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK));
    }
    
    public void changeFontSize(int val){
        fontsize = val;
    }

    public int get() {
        return user.getInt(4);
    }
    
    public void putScore(int val){
        if (user.isStorageAvailable()) {
            user.setInt(4, val);
            user.store();
        }
    }
}
