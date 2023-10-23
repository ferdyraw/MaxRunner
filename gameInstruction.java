import greenfoot.*;  

public class gameInstruction extends World
{
    private int currentInstruction = 2; // Mengikuti langkah instruksi saat ini
    private int timer = 0;
    private int lastSpace;
    private boolean canChangeInstruction = true;
    
    public gameInstruction()
    {   
        super(600, 400, 1); 
        setBackground("intruksi_1.png");
    }
    
    public void act()
    {
        timer++;
        
        if (Greenfoot.isKeyDown("space") && (timer-lastSpace > 5)) {
            if (currentInstruction != 4) {
                setBackground("intruksi_" + currentInstruction + ".png");
                lastSpace = timer;
            }
            currentInstruction++;
        }
        if (timer - lastSpace > 5){
            canChangeInstruction = true;
        }
        if(Greenfoot.isKeyDown("escape") || currentInstruction == 5){
            Greenfoot.setWorld(new gameMenu());
        }
    }
}

    
