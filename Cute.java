import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cute extends Actor
{
    public GreenfootImage[] imagesRun= new GreenfootImage[8];
    public GreenfootImage[] imagesJump= new GreenfootImage[12];
    public GreenfootImage[] imagesIdle= new GreenfootImage[5];
    public int countRun= 0;
    public int countRun1 = 0;
    public int countJump = 0;
    public int countJump1 = 0;
    public int countIdle = 0;
    public int countIdle1 = 0;
    public final int gravitasi = 1;
    public int kecepatan;
    public boolean falling = false;
    public GreenfootSound backSoundCoin;
    public int score = 0;
    public int num = 1;
    /*
     * Act - do whatever the dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Cute(){
        animJump();
        animRun();
        animIdle();
        kecepatan = 0;
        
        
    }
    public void act()
    {
        
    }
    public void Running(){
        if(countRun1 % 4 == 0 ){
        setImage(imagesRun[countRun++ %8]);
        
        }
        if(countRun1 > 32){
            countRun1 = 0;
        }
        countRun1 ++;
    
    }
    public void animRun(){
       for(int i = 0; i < 8; i++){
            int a = i+1;
            String filename = "CuteRun_"+ a + ".png";
            imagesRun[i] = new GreenfootImage(filename);   
        } 
    }
    public void animJump(){
        for(int i = 0; i < 8; i++){
            int a = i+1;
            String filename = "CuteJump_"+ a + ".png";
            imagesJump[i] = new GreenfootImage(filename);   
        } 
        
    }
    public void animIdle(){
        for(int i = 0; i < 5; i++){
            int a = i+1;
            String filename = "CuteIdle_"+ a + ".png";
            imagesIdle[i] = new GreenfootImage(filename);   
        }     
    }
    public void Idle(){
        
        if(countIdle1 % 8 == 0 ){
        setImage(imagesIdle[countIdle++ %5]);
        
        }
        if(countIdle1 > 40){
            countIdle1 = 0;
        }
        countIdle1 ++;
    }
    public void Jumping(){
        if(countJump1 % 3 == 0 ){
        setImage(imagesJump[countJump++ %8]);
        
        }
        if(countJump1 > 24){
            countJump1 = 0;
        }
        countJump1 ++;
    }
    
    public void jump(){
        kecepatan = -13;
    }
    
    public void addScore(){
        World myWorld = getWorld();
        Main bg = (Main)myWorld;
        
        score++;
        if (score % 5 == 0){
            
            Counter counter = bg.getCounter();
            counter.addScore();
        }
    }
    
    public void out(){
        setLocation(getX() + num, getY());
        if(getX() == 200){
            num = 0;
        } 
    
    }
}