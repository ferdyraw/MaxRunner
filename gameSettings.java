import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class gameSettings extends World
{
    public int musicSelection = 0;
    public int diaSelection = 0;
    public int soundSelection = 0;
    public int currentSelection = 0;
    
    private GreenfootImage[] musicImages = new GreenfootImage[4];
    private GreenfootImage[] soundImages = new GreenfootImage[4];
    
    private MenuOption[] musicOptions = new MenuOption[4];
    private GreenfootImage[] menuImages = new GreenfootImage[4];
    
    private MenuOption[] soundOptions = new MenuOption[4];
    private GreenfootImage[] dialogImages = new GreenfootImage[2];
    
    private MenuOption[] menuOptions = new MenuOption[4];
    
    private GreenfootImage[] soundIconImages = new GreenfootImage[4];
    
    private MenuOption dialogOptions;
    private MenuOption musicIconOptions;
    private MenuOption soundIconOptions;
    
    private GreenfootSound backsoundStart;
    
    private boolean keyRightmusicPressed = false;
    private boolean keyLeftmusicPressed = false;

    private boolean keyRightsoundPressed = false;
    private boolean keyLeftsoundPressed = false;
    
    private boolean keyRightDiaPressed = false;
    private boolean keyLeftDiaPressed = false;
    
    private boolean keymusicPressed = true;
    private boolean keysoundPressed = false;
    private boolean keyDiaPressed = false;
    
    private boolean keyDownPressed = false;
    private boolean keyUpPressed = false;
    
    private int timer = 0;
    
    private int Xaxis = getWidth() / 4 + 160;
    private int Yaxis = getHeight() / 4 + 55;

    public gameSettings()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
    }
    
    private void prepare() {
        
        int spacing = 100;

        // Inisialisasi gambar-gambar menu
        musicImages[0] = new GreenfootImage("soundmute.png");
        musicImages[1] = new GreenfootImage("sound1.png");
        musicImages[2] = new GreenfootImage("sound1.png");
        musicImages[3] = new GreenfootImage("sound1.png");
        
        soundImages[0] = new GreenfootImage("soundmute.png");
        soundImages[1] = new GreenfootImage("sound1.png");
        soundImages[2] = new GreenfootImage("sound1.png");
        soundImages[3] = new GreenfootImage("sound1.png");
        
        dialogImages[0] = new GreenfootImage("onsetting.png");
        dialogImages[1] = new GreenfootImage("offsetting.png");
        
        menuImages[0] = new GreenfootImage("music.png");
        menuImages[1] = new GreenfootImage("sound.png");
        menuImages[2] = new GreenfootImage("storymenu.png");
        menuImages[3] = new GreenfootImage("save.png");
    
        soundIconImages[0] = new GreenfootImage("soundgameoff.png");
        soundIconImages[1] = new GreenfootImage("soundgameon1.png");
        soundIconImages[2] = new GreenfootImage("soundgameon2.png");
        soundIconImages[3] = new GreenfootImage("soundgameon3.png");
        
        
        for (int i = 0; i < 4; i++) {
            musicOptions[i] = new MenuOption(musicImages[i], Xaxis, Yaxis + spacing * i);
            soundOptions[i] = new MenuOption(soundImages[i], Xaxis, Yaxis + spacing * i);
            menuOptions[i] = new MenuOption(menuImages[i], Xaxis, Yaxis + spacing * i);
            
        }
        
        addObject(menuOptions[0], Xaxis - 100, Yaxis + 40 * 0);
        addObject(menuOptions[1], Xaxis - 100, Yaxis + 40 * 1);
        addObject(menuOptions[2], Xaxis - 100, Yaxis + 40 * 2);
        addObject(menuOptions[3], Xaxis, Yaxis + 40 * 3);

        
        dialogOptions = new MenuOption(dialogImages[0], Xaxis, Yaxis + spacing);
        addObject(dialogOptions, Xaxis + 40, Yaxis + 80);
        
        musicIconOptions = new MenuOption(soundIconImages[0], Xaxis, Yaxis + spacing);
        addObject(musicIconOptions, Xaxis + 110, Yaxis);
        
        soundIconOptions = new MenuOption(soundIconImages[0], Xaxis, Yaxis + spacing);
        addObject(soundIconOptions, Xaxis + 110, Yaxis + 40);
        
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            diaSelection = myInfo.getInt(0);
            musicSelection = myInfo.getInt(1);
            soundSelection = myInfo.getInt(2);
        }

        updateSelectionmusic();
        updateSelectionsound();
        updateSelectionDia();
        updateSelection();
        
    }
    
    public void act() {
        timer++;
        checkKeyPress();
    }
    
    private void checkKeyPress() {
        if(keymusicPressed){
            if (Greenfoot.isKeyDown("right")) {
                if (!keyRightmusicPressed) {
                    musicSelection = (musicSelection + 1) % musicOptions.length;
                    updateSelectionmusic();
                    keyRightmusicPressed = true;
                }
            } else {
                keyRightmusicPressed = false;
            }
            if (Greenfoot.isKeyDown("left")) {
                if (!keyLeftmusicPressed) {
                    musicSelection = (musicSelection - 1 + musicOptions.length) % musicOptions.length;
                    updateSelectionmusic();
                    keyLeftmusicPressed = true;
                }
            } else {
                keyLeftmusicPressed = false;
            }
        }
        
        if(keysoundPressed){
            if (Greenfoot.isKeyDown("right")) {
                if (!keyRightsoundPressed) {
                    soundSelection = (soundSelection + 1) % soundOptions.length;
                    updateSelectionsound();
                    keyRightsoundPressed = true;
                }
            } else {
                keyRightsoundPressed = false;
            }
            if (Greenfoot.isKeyDown("left")) {
                if (!keyLeftsoundPressed) {
                    soundSelection = (soundSelection - 1 + soundOptions.length) % soundOptions.length;
                    updateSelectionsound();
                    keyLeftsoundPressed = true;
                }
            } else {
                keyLeftsoundPressed = false;
            }
            
        }
        
        
        if(keyDiaPressed){
            if (Greenfoot.isKeyDown("right")) {
                if (!keyRightDiaPressed) {
                    diaSelection = (diaSelection + 1) % 2;
                    updateSelectionDia();
                    keyRightDiaPressed = true;
                }
            } else {
                keyRightDiaPressed = false;
            }
    
            if (Greenfoot.isKeyDown("left")) {
                if (!keyLeftDiaPressed) {
                    diaSelection = (diaSelection - 1 + 2) % 2;
                    updateSelectionDia();
                    keyLeftDiaPressed = true;
                }
            } else {
                keyLeftDiaPressed = false;
            }
        }
        
        if (Greenfoot.isKeyDown("down")) {
            if (!keyDownPressed) {
                currentSelection = (currentSelection + 1) % menuOptions.length;
                updateSelection();
                keyDownPressed = true;
            }
        } else {
            keyDownPressed = false;
        }

        if (Greenfoot.isKeyDown("up")) {
            if (!keyUpPressed) {
                currentSelection = (currentSelection - 1 + menuOptions.length) % menuOptions.length;
                updateSelection();
                keyUpPressed = true;
            }
        } else {
            keyUpPressed = false;
        }
        
        if(currentSelection == 0){
            keymusicPressed = true;
            keyDiaPressed = false;
            keysoundPressed = false;
        }
        
        if(currentSelection == 1){
            keymusicPressed = false;
            keyDiaPressed = false;
            keysoundPressed = true;
        }
        
        if(currentSelection == 2){
            keymusicPressed = false;
            keyDiaPressed = true;
            keysoundPressed = false;
        }
        if(currentSelection == 3){
            keymusicPressed = false;
            keyDiaPressed = false;
            keysoundPressed = false;
            if(Greenfoot.isKeyDown("space")){
                selectOption();
            }
        }
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }

    private void updateSelectionmusic() {
        
        
        if(musicSelection == 0){
            addObject(musicOptions[0], Xaxis, Yaxis);
            removeObject(musicOptions[1]);
            removeObject(musicOptions[2]);
            removeObject(musicOptions[3]);
            musicIconOptions.setImage(soundIconImages[0]);
        }
        
        if(musicSelection == 1){
            addObject(musicOptions[0], Xaxis, Yaxis);
            addObject(musicOptions[1], Xaxis + 20, Yaxis);
            removeObject(musicOptions[2]);
            removeObject(musicOptions[3]);
            musicIconOptions.setImage(soundIconImages[1]);
        }
        
        if(musicSelection == 2){
            addObject(musicOptions[0], Xaxis, Yaxis);
            addObject(musicOptions[1], Xaxis + 20, Yaxis);
            addObject(musicOptions[2], Xaxis + 60, Yaxis);
            removeObject(musicOptions[3]);
            musicIconOptions.setImage(soundIconImages[2]);
        }
        if(musicSelection == 3){
            addObject(musicOptions[0], Xaxis, Yaxis);
            addObject(musicOptions[1], Xaxis + 20, Yaxis);
            addObject(musicOptions[2], Xaxis + 60, Yaxis);
            addObject(musicOptions[3], Xaxis + 100, Yaxis);
            musicIconOptions.setImage(soundIconImages[3]);
        }
        
        
    }
    
    private void updateSelectionsound() {
        
        
        if(soundSelection == 0){
            addObject(soundOptions[0], Xaxis, Yaxis + 40);
            removeObject(soundOptions[1]);
            removeObject(soundOptions[2]);
            removeObject(soundOptions[3]);
            soundIconOptions.setImage(soundIconImages[0]);
        }
        
        if(soundSelection == 1){
            addObject(soundOptions[0], Xaxis, Yaxis + 40);
            addObject(soundOptions[1], Xaxis + 20, Yaxis + 40);
            removeObject(soundOptions[2]);
            removeObject(soundOptions[3]);
            soundIconOptions.setImage(soundIconImages[1]);
        }
        
        if(soundSelection == 2){
            addObject(soundOptions[0], Xaxis, Yaxis + 40);
            addObject(soundOptions[1], Xaxis + 20, Yaxis + 40);
            addObject(soundOptions[2], Xaxis + 60, Yaxis + 40);
            removeObject(soundOptions[3]);
            soundIconOptions.setImage(soundIconImages[2]);
        }
        if(soundSelection == 3){
            addObject(soundOptions[0], Xaxis, Yaxis + 40);
            addObject(soundOptions[1], Xaxis + 20, Yaxis + 40);
            addObject(soundOptions[2], Xaxis + 60, Yaxis + 40);
            addObject(soundOptions[3], Xaxis + 100, Yaxis + 40);
            soundIconOptions.setImage(soundIconImages[3]);
        }
        
        
    }
    
    private void updateSelectionDia() {
        
        if(diaSelection == 0){
            dialogOptions.setImage(dialogImages[0]);

        }
        
        if(diaSelection == 1){
            dialogOptions.setImage(dialogImages[1]);
        }
    }
    
    private void updateSelection() {
        for (int i = 0; i < menuOptions.length; i++) {
            if (i == currentSelection) {
                menuOptions[i].setSelected(true);
            } else {
                menuOptions[i].setSelected(false);
            }
        }
    }
    
    private void selectOption() {
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            myInfo.setInt(0, diaSelection);
            myInfo.setInt(1, musicSelection);
            myInfo.setInt(2, soundSelection);
            myInfo.store();
        }
    }
}
