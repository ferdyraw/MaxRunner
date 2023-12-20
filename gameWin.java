import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameWin extends World
{
    private GreenfootImage backgroundImage;
    private GreenfootSound backsoundReward;
    private GreenfootSound backsound;
    private int timer = 0;
    private int startHighscore = Integer.MAX_VALUE;
    private boolean isHighscore = false;
    private boolean isDiag = false;
    private int volume = 0;
    
    Highscore highscore = new Highscore();
    Counter counter = new Counter();
    PortalB portal = new PortalB();
    DialogueWin dialogue = new DialogueWin();
    
    public gameWin()
    {    
        super(600, 400, 1, false); 
        backgroundImage = new GreenfootImage("bege4.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    public void prepare(){
        highscore.putScore(counter.get());
        
        addObject(new Blockwin(), 300, 350);
        addObject(portal, 1, 250);
    }
    
    public void act(){
        timer++;
        
        if (timer == 1) {
            portal.soundClose();
        }
        
        if (timer == 60) {
            addObject(new Cuteinwin(), 55, 250);
        }
        
        if (timer == 200) {
            if (UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                if (myInfo.getInt(0) == 0) {
                    addObject(dialogue, 300, 80);
                    dialogue.soundDialogue();
                    isDiag = true;
                }
            }
        }
        
        if (isDiag && timer == 400) {
            dialogue.next();
        }
        
        if (timer == 450) {
            addObject(highscore, 300, 100);
            backsoundReward = new GreenfootSound("reward.mp3");
            backsoundReward.setVolume(70);
            backsoundReward.play();
            startHighscore = timer;
        }
        
        
        if ((timer-startHighscore) == 15) {
            if (UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                volume = myInfo.getInt(1);
                if (volume != 0) {
                    backsound = new GreenfootSound("gamesound4.mp3");
                    backsound.setVolume(5);
                    backsound.play();
                    isHighscore = true;
                }
            }
        }
        
        if (isHighscore == true) {
            if (volume >= 1 && (timer-startHighscore) == 25) {
                backsound.setVolume(15);
            } else if (volume >= 1 && (timer-startHighscore) == 30) {
                backsound.setVolume(25);
            } else if (volume >= 2 && (timer-startHighscore) == 40) {
                backsound.setVolume(35);
            } else if (volume >= 2 && (timer-startHighscore) == 50) {
                backsound.setVolume(45);
            } else if (volume >= 3 && (timer-startHighscore) == 65) {
                backsound.setVolume(55);
            } else if (volume >= 3 && (timer-startHighscore) == 80) {
                backsound.setVolume(65);
            }
        }

        if(Greenfoot.isKeyDown("R")){
            Greenfoot.setWorld(new Lab());
            if (backsound != null) backsound.stop();
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
            if (backsound != null) backsound.stop();
        }
    }

}