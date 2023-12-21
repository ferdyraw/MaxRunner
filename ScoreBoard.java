import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
 
/**
 * An actor class that can display a scoreboard, using Greenfoot's
 * UserInfo class.  
 * 
 * You typically use this by including some code into the world for when your game ends:
 * 
 * <pre>
 *   addObject(new ScoreBoard(800, 600), getWidth() / 2, getHeight() / 2); 
 * </pre>
 * 
 * Where 800 by 600 should be replaced by the desired size of the score board. 
 * 
 * @author Neil Brown 
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    // The vertical gap between user images in the scoreboard:
    private static final int GAP = 3;
    // The height of the "All Players"/"Near Me" text at the top:
    private static final int HEADER_TEXT_HEIGHT = 10;
    // The main text color:
    private static final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); // dark grey
    // The score color (updated to red):
    private static final Color SCORE_COLOR = new Color(0xFF, 0x00, 0x00); // red
    // The background colors:
    private static final Color BACKGROUND_COLOR = new Color(0xFF, 0xFF, 0xFF, 0xB0);
    private static final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(180, 230, 255, 0xB0);
    private ArrayList<PlayerData> playerDataList = new ArrayList<>();

    int score;
 
    /**
     * Constructor for objects of class ScoreBoard.
     * <p>
     * You can specify the width and height that the score board should be, but
     * a minimum width of 600 will be enforced.
     */
    public ScoreBoard()
    {    
        UserInfo userInfo = UserInfo.getMyInfo();
        this.score = userInfo.getScore();
        setImage(new GreenfootImage(600, 400)); 
        drawScores();
    }
 
    private void drawString(String text, int x, int y, Color color, int height)
    {
        // getImage().drawImage(new GreenfootImage(text, height, color, new Color (0, true)), x, y);
        getImage().drawImage(new GreenfootImage(text, height, color, null), x, y);
    }
 
    private void drawScores()
    {
        // 50 pixels is the max height of the user image
        final int pixelsPerUser = 50 + 2*GAP;
        // Calculate how many users we have room for:
        final int numUsers = ((getImage().getHeight() - (HEADER_TEXT_HEIGHT + 10)) / pixelsPerUser);
        final int topSpace = (getImage().getHeight() - (numUsers * pixelsPerUser) - GAP);
 
        //getImage().setColor(BACKGROUND_COLOR);
        //getImage().fill();
        
        List<UserInfo> allPlayers = UserInfo.getTop(50);
        Collections.sort(allPlayers, Comparator.comparingInt(UserInfo::getScore));
 
        drawUserPanel(GAP, topSpace, (getImage().getWidth() / 2) - GAP, topSpace + numUsers * pixelsPerUser, allPlayers);
    }
 
    private void drawUserPanel(int left, int top, int right, int bottom, List users)
    {
        getImage().setColor(MAIN_COLOR);
        //getImage().drawRect(left, top, right - left, bottom - top);
 
        if (users == null)
            return;
 
        UserInfo me = UserInfo.getMyInfo();
        int y = top + GAP;
        for (int i = 0; i < Math.min(users.size(), 5); i++)
        {
            Object obj = users.get(i);
            UserInfo playerData = (UserInfo)obj;     
            // apabila warna background error
            Color c = null;
 
            //int x = left + 10;
            int x = 180;
            drawString("#" + Integer.toString(i+1), x, y+95, null, 35);
            x += 138;
            //drawString(Integer.toString(playerData.getScore()), x, y+18, SCORE_COLOR, 14);
            drawString(playerData.getUserName(), x, y + 95, null, 35);
            x += 95;
            //getImage().drawImage(playerData.getUserImage(), x, y);
            x += 293;
            //drawString(playerData.getUserName(), x, y + 18, MAIN_COLOR, 14);
            drawString(Integer.toString(playerData.getScore()), x, y+95, SCORE_COLOR, 35);
            y += 50 + 2*GAP;
        }
    }
    
    // Menambahkan kelas PlayerData untuk menyimpan informasi pemain
    private static class PlayerData {
        private int rank;
        private int score;
        private String userName;

        public PlayerData(int rank, int score, String userName) {
            this.rank = rank;
            this.score = score;
            this.userName = userName;
        }

        public int getRank() {
            return rank;
        }

        public int getScore() {
            return score;
        }

        public String getUserName() {
            return userName;
        }
    }
}