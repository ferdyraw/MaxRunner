import greenfoot.*;  // atau package yang sesuai

public class MenuOption extends Actor {
    private GreenfootImage optionImage;
    private GreenfootSound backsoundMenu;
    private boolean isSelected;

    public MenuOption(GreenfootImage image, int x, int y) {
        optionImage = image;
        isSelected = false;
        setImage(optionImage);
        setLocation(x, y);
    }

    public void act() {
        // Tambahkan logika tambahan jika diperlukan
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        updateImage();
    }

    private void updateImage() {
        if (isSelected) {
            // Misalnya, tambahkan efek visual tambahan untuk menandai opsi yang dipilih
            GreenfootImage updatedImage = new GreenfootImage(optionImage);
            updatedImage.scale((int) (optionImage.getWidth() * 1.2), (int) (optionImage.getHeight() * 1.2));
            setImage(updatedImage);
            backsoundMenu = new GreenfootSound("menu_sound.mp3");
            backsoundMenu.setVolume(30);
            backsoundMenu.play();
        } else {
            setImage(optionImage);
        }
    }
}
