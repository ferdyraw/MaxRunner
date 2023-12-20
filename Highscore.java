import greenfoot.*;
import java.util.*;

public class Highscore extends Actor
{
    public UserInfo user;
    
    public Highscore() {
        user = UserInfo.getMyInfo();
    }
    
    public void act()
    {
        displayTop3Leaderboard();
    }
    
    public void putScore(int score){
        int minScore = Math.min(user.getScore(), score);   
        if (user.isStorageAvailable()) {
            user.setScore(minScore);
            user.store();
        }
    }
    
    public void displayTop3Leaderboard() {
        List<UserInfo> leaderboard = getLeaderboard();
        GreenfootImage image = new GreenfootImage("Leaderboard", 30, greenfoot.Color.LIGHT_GRAY, greenfoot.Color.BLACK);
        
        for (int i = 0; i < Math.min(leaderboard.size(), 3); i++) {
            UserInfo player = leaderboard.get(i);
            image.drawString((i + 1) + ". " + player.getUserName() + ": " + player.getScore(), 10, 40 + i * 30);
        }
        
        setImage(image);
    }
    
    private List<UserInfo> getLeaderboard() {
        // Mendapatkan semua pemain dan menyusunnya berdasarkan skor terendah
        List<UserInfo> allPlayers = user.getTop(10); // Ambil 10 pemain teratas
        Collections.sort(allPlayers, Comparator.comparingInt(UserInfo::getScore)); // Urutkan berdasarkan skor terendah
        return allPlayers;
    }
}