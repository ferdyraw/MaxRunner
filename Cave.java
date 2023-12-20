import greenfoot.*; 
import java.util.List;
import java.util.Arrays;
import java.util.Random; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Main
{
    private boolean zero = false;
    private boolean ten = false;
    private boolean isCute = false;
    private boolean dun = false;
    private int lastDialogue;
    private int startPortal = 0;
    private int count = 0;
    private int volume = 0;
    
    Cuteincave cute = new Cuteincave();
    Coolincave cool = new Coolincave();
    PortalB portalb = new PortalB();
    DialogueCave1 dialogue = new DialogueCave1();
    DialogueCave2 dialogue2 = new DialogueCave2();
    
    List <Integer> spawnDrink = Arrays.asList(260);
    Random rand = new Random();
    
    public Cave()
    {
        super();
        backgroundImage = new GreenfootImage("bege2.png");
        setBackground(backgroundImage);
        prepare();
    }
    
    private void prepare()
    {   
        addObject(new Blockcave(), 300,335);
        addObject(new Blockcave2(), 300, 25);
        addObject(counter, 75, 40);
        addObject(energy, 515, 40);
        addObject(portalb, 1, 184);
    }
    public void act(){
        super.act();
        
        if (timer == 1) {
            portalb.soundClose();
        }
        
        if (timer == 1) {
            if (UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                volume = myInfo.getInt(1);
                if (volume != 0) {
                    backsound = new GreenfootSound("gamesound2.mp3");
                    backsound.setVolume(5);
                    backsound.play();
                }
            }
        } else if (volume >= 1 && timer == 10) {
            backsound.setVolume(15);
        } else if (volume >= 1 && timer == 15) {
            backsound.setVolume(25);
        } else if (volume >= 2 && timer == 25) {
            backsound.setVolume(35);
        } else if (volume >= 2 && timer == 35) {
            backsound.setVolume(45);
        } else if (volume >= 3 && timer == 50) {
            backsound.setVolume(55);
        } else if (volume >= 3 && timer == 65) {
            backsound.setVolume(65);
        }
        
        if(timer == 60){
            addObject(cute, 55, 184);
            isCute = true;
        }
        
        if (portalb.getX() == 0) {
            addObject(cool, 0, 184);
            if (UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                if (myInfo.getInt(0) == 0) {
                    addObject(dialogue, 300, 80);
                    dialogue.soundDialogue();
                    lastDialogue = timer;
                    zero = true;
                }
            }
        }
        
        if (zero == true && count < 3) {
            if ((timer-lastDialogue) == 200) {
                dialogue.next();
                lastDialogue = timer;
                count++;
            }
        }
        
        if (energy.energy < 10) {
            if (timer % 900 == 0){
                addObject(new Dot2(), 600, 79);
                addObject(new ObstacleDrop(), 600, 89);
            }
            
            if (timer % 350 == 0 && energy.energy < 9){
                addObject(new ObstacleLava(), 630, 302);
            }
            
            if (timer % 170 == 0) {
                int randomIdx = rand.nextInt(spawnDrink.size());
                int randomPos = spawnDrink.get(randomIdx);
                addObject(new Drink(), 620, randomPos);
            }
            
            if (timer % 210 == 0 && energy.energy < 9) {
                addObject(new Dot2(), 600, 79);
                addObject(new ObstacleDrop2(), 600, 89);
            }
            
            if (cool != null && timer > 350 && timer % 350 == 85 && cool.getY() == 250) {
                cool.jump();
            }
            
            if (cool != null && timer > 900 && timer % 900 == 100 && cool.getY() == 250)
            {
                cool.jump();
            }
            
            if (cool != null && timer > 100 &&  timer % 210 == 100 && cool.getY() == 250) {
                cool.jump();
            }
        } else if (energy.energy == 10 && ten == false && dun == false) {
            if (UserInfo.isStorageAvailable()) {
                UserInfo myInfo = UserInfo.getMyInfo();
                if (myInfo.getInt(0) == 0) {
                    addObject(dialogue2, 300, 80);
                    dialogue2.soundDialogue();
                    ten = true;
                }
            }
            dun = true;
        }
        
        if(timer % 7 == 0){
            scrollPosition = (scrollPosition - scrollSpeed) % getWidth();
            paint(scrollPosition);
        }
        
        if (isCute == true && Greenfoot.isKeyDown("space") && cute.isOnGround() && cute.getX() == 200) {
            cute.jump();
            soundJump();
        }
        
        if (isCute == true && cute.startPortal == true) {
            if (startPortal == 0) {
                startPortal = timer;
            } else if (volume >= 3 && timer-startPortal == 40) {
                backsound.setVolume(60);
            } else if (volume >= 3 && timer-startPortal == 80) {
                backsound.setVolume(50);
            } else if (volume >= 2 && timer-startPortal == 120) {
                backsound.setVolume(40);
            } else if (volume >= 2 && timer-startPortal == 180) {
                backsound.setVolume(30);
            } else if (volume >= 1 && timer-startPortal == 210) {
                backsound.setVolume(20);
            } else if (volume >= 1 && timer-startPortal == 230) {
                backsound.setVolume(10);
            } else if (volume >= 1 && timer-startPortal == 250) {
                backsound.setVolume(5);
            }
        }
        
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
            if (backsound != null) backsound.stop();
        }
        
        if (Greenfoot.isKeyDown("R")) {
            Greenfoot.setWorld(new Lab());
            if (backsound != null) backsound.stop();
        }
    }
}
