import greenfoot.*;  // atau package yang sesuai

public class GameMenu extends World {
    private String[] menuOptions = {"Play", "How to Play", "Exit"};
    private int currentSelection = 0;
    private boolean keyDownPressed = false;
    private boolean keyUpPressed = false;

    
    Highscore highscore = new Highscore();
    
    public GameMenu() {
        super(600, 400, 1); // Atur ukuran dunia sesuai kebutuhan Anda
        prepare();
    }

    private void prepare() {
        highscore.putScore(0);
        for (int i = 0; i < menuOptions.length; i++) {
            addObject(new MenuOption(menuOptions[i]), getWidth() / 2, getHeight() / 2 + 50 * i);
        }
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
        for (Object obj : getObjects(MenuOption.class)) {
            MenuOption option = (MenuOption) obj;
            option.setSelected(false);
        }
        MenuOption currentOption = (MenuOption) getObjects(MenuOption.class).get(currentSelection);
        currentOption.setSelected(true);
    }
    private void selectOption() {
        if (currentSelection == 0) {
            // Pindah ke lapisan permainan
            Greenfoot.setWorld(new gameBackground()); // Ganti dengan kelas dunia permainan Anda
        } else if (currentSelection == 1) {
            // Pindah ke tampilan cara bermain
            // Lakukan apa pun yang diperlukan untuk menampilkan tampilan cara bermain
        } else if (currentSelection == 2) {
            // Keluar dari permainan
            Greenfoot.stop();
        }
    }
}

