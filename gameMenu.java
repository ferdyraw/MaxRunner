import greenfoot.*;  // atau package yang sesuai

public class gameMenu extends World {
    private int currentSelection = 0;
    private GreenfootImage[] menuImages = new GreenfootImage[3];
    private MenuOption[] menuOptions = new MenuOption[3];
    
    private boolean keyDownPressed = false;
    private boolean keyUpPressed = false;

    Counter counter = new Counter();    
    Highscore highscore = new Highscore();
    
    public gameMenu() {
        super(600, 400, 1); // Atur ukuran dunia sesuai kebutuhan Anda
        prepare();
    }

    private void prepare() {
        highscore.putScore(Integer.MAX_VALUE);
        counter.putScore(0);
        
        int initialX = getWidth() / 2;
        int initialY = getHeight() / 2;
        int spacing = 70;

        // Inisialisasi gambar-gambar menu
        menuImages[0] = new GreenfootImage("Run_1.png");
        menuImages[1] = new GreenfootImage("Run_2.png");
        menuImages[2] = new GreenfootImage("Run_3.png");

        for (int i = 0; i < 3; i++) {
            menuOptions[i] = new MenuOption(menuImages[i], initialX, initialY + spacing * i);
            addObject(menuOptions[i], initialX, initialY + spacing * i);
        }
        updateSelection();
    }

    public void act() {
        checkKeyPress();
    }

    private void checkKeyPress() {
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

        if (Greenfoot.isKeyDown("space")) {
            selectOption();
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
        if (currentSelection == 0) {
            // Pindah ke lapisan permainan
            Greenfoot.setWorld(new Lab()); // Ganti dengan kelas dunia permainan Anda
        } else if (currentSelection == 1) {
            // Pindah ke tampilan cara bermain
            // Lakukan apa pun yang diperlukan untuk menampilkan tampilan cara bermain
        } else if (currentSelection == 2) {
            // Keluar dari permainan
            Greenfoot.stop();
        }
    }
}


