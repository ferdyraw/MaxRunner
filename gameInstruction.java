import greenfoot.*;  

public class gameInstruction extends World
{
    private int currentInstruction = 1; // Mengikuti langkah instruksi saat ini
    
    public gameInstruction()
    {   
        super(600, 400, 1); 
        setBackground("instruksi_1.png");
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) {
            switch (currentInstruction) {
                case 1:
                    setBackground("instruksi_2.png");
                    currentInstruction++;
                    break;
                case 2:
                    setBackground("instruksi_3.png");
                    currentInstruction++;
                    break;
                case 3:
                    Greenfoot.setWorld(new gameMenu()); 
                    break;
            }
        }
        if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new gameMenu());
        }
    }
    
    public void prepare()
    {
        
    }
}

    
