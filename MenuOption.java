import greenfoot.*;  // atau package yang sesuai

public class MenuOption extends Actor {
    private String optionText;
    private boolean isSelected;
   
    public MenuOption(String text) {
        optionText = text;
        isSelected = false;
        updateImage();
    }

    public void act() {
        // Tambahkan logika tambahan jika diperlukan
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(200, 50);
        if (isSelected) {
            img.setColor(Color.RED);
        } else {
            img.setColor(Color.WHITE);
        }
        img.fill();
        img.setColor(Color.BLACK);
        img.drawString(optionText, 50, 30);
        setImage(img);
    }
    
}
