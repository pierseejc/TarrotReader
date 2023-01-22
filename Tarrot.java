package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Texture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;





public class Tarrot {

    private int TargetCardNum;
    private String CardDescript;
    private String CardImage;
    private String BigHeader;
    


    //Construcutor
    public Tarrot (int RandNum, String CardDescript, String AsciImage, String Header){
        this.TargetCardNum = RandNum;
        this.CardDescript = CardDescript;
        this.CardImage = AsciImage;
        this.BigHeader = Header;

    }

    //Card number pull
    public static ArrayList<Integer> Card(){
     ArrayList<Integer> CardDeck = new ArrayList<Integer>();
      Random Pull = new Random();

      for (int i = 0; i < 5; i++){
        int temp = Pull.nextInt(77);
        CardDeck.add(temp);
    }
    return CardDeck;

}

//Deck Requires Redraw
public static boolean Redraw(ArrayList<Integer> CardDeck){

        boolean NeedRedraw = false;
     for (int Cardnum : CardDeck){
        int count = 0;
        int Temp = Cardnum;
        count = count +1;
        //System.out.println("Temp=" + Temp);
        //System.out.println("Index=" + CardDeck.get(count));
        if (Temp == CardDeck.get(count)){
            NeedRedraw = true;
        }
    }

    return NeedRedraw;

    }

    //Header pull
    public static String Header(int Cardnum) throws FileNotFoundException{
        File Headers = new File("/home/devilharvest/GameDevEnv/assets/TarrotHeaders.txt");
        Scanner Scanner = new Scanner(Headers);
        
        
        String Card = Integer.toString(Cardnum);
        String Header = "";

        while (Scanner.hasNext()){
          String temp = Scanner.nextLine();
          if (temp.contains(Card)){
            Header = temp;
          }
        
        }

        return Header;
        
    }

    //Controller
    public static void Controller() throws FileNotFoundException{
        Boolean Inplay = true;
        Scanner Input = new Scanner(System.in);

        System.out.println("Welcome to the Tarot Reader");
            //Thread.sleep(5);
            //jSystem.out.flush();
            System.out.println("Are you ready to Learn your fate?");
            String PlayerResponse = Input.next();
            while (true){
            
            if (PlayerResponse =="no"){
                System.out.println("Goodbye");
                break;
            }
            
            
            if (PlayerResponse == "yes" || PlayerResponse == "sure" || PlayerResponse == "y"){
                //System.out.flush();
                System.out.println("Think of your fate");
                //Thread.sleep(5);
                //System.out.flush();
                System.out.println("Ponder its meaning");
                //Thread.sleep(5);
                ArrayList<Integer> PlayerDraw = Card();

                if (Redraw(PlayerDraw) == false){
                    System.out.flush();
                    System.out.println("Your Fate is sealed");
                    for(int card : PlayerDraw){
                        System.out.println(Header(card));}
                    Inplay = false;

                
                }



                
                if(Redraw(PlayerDraw) == true){
                    PlayerDraw = Card();
                    System.out.flush();
                    System.out.println("The fates have changed");
                    //Thread.sleep(5);
                    for(int card : PlayerDraw){
                        System.out.println(Header(card));}
                    Inplay = false;

                }}}
                
            
                



            }

        
    
    





    public static void main(String args[]) throws FileNotFoundException, InterruptedException{
        Controller();
        
        }
        
    }
    
