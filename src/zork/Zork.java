package zork;

import java.util.Scanner;
import java.util.ArrayList;

public class Zork {
    
    static ArrayList<String>inventory= new ArrayList<>();
    static String garageKey;
    static String entranceKey;
    static String room4Key;
    static String spade;
    static String clothesPeg;
    static String mirror;
    
    public static void main(String[] args) {
        System.out.println("welcome to zork. \n the aim of this game is to escape the house \n type in a direction to move that way");
        System.out.println("you wake up. /n you are in a strange room. /n you have no recolection of how you got here or even where you are. \n you dont even know who you are.");
        room1();
    }
    
    public static String getUserInput(){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        return input;
    }
    
    public static void room1(){
        System.out.println("You apear to be in a disused bedroom. \n there is a door north of your possition");
        String move = getUserInput();
        if(move.equals("north")){
            hall();
        }else{
            room1();
        }
    }
    
    public static void hall(){
        System.out.println("you are in a long hallway. \n there are doors to your north, northeast, east, southeast, southwest, west, northwest.");
        String move = getUserInput();
        if(move.equals("north")){
            entrance();
        }
        else if(move.equals("northeast")){
            room4();
        }
        else if(move.equals("east")){
            room5();
        }
        else if(move.equals("southeast")){
            room1();
        }
        else if(move.equals("southwest")){
            room2();
        }
        else if(move.equals("west")){
            room3();
        }
        else if(move.equals("northwest")){
            kitchen();
        }else{
            hall();
        }
    }
    
    public static void room2(){
      System.out.println("you now find yourself in an out dated living room with doors to the south and east");
      String move = getUserInput();
      if(move.equals("south")){
          hall();
      }
      else if(move.equals("west")){
          room3();
      }else{
          room2();
      }
    }
    
    public static void room3(){
       System.out.println("now you walk into a family sized dining room that looks like it has not seen use since the living room was trendy. \n there are doors east, south and west.");
       String move = getUserInput();
       if(move.equals("south")){
          hall();
      }
       else if(move.equals("east")){
          kitchen();
      }
       else if(move.equals("west")){
          room2();
      }else{
           room3();
       }
    }
    
    public static void room4(){
     System.out.println("what is that SMELL! \n the door is to your south");
     System.out.println("there could be useful objects in the cupboard would you like to take a look");
        String lookAround = getUserInput();
        if (lookAround.equals("yes")){
        if(inventory.contains(clothesPeg)&&inventory.contains(room4Key)&&!inventory.contains(garageKey)){
            System.out.println("there is a key would you like to pick it up?");
            String pickUp = getUserInput();
            if(pickUp.equals("yes")){
                inventory.add(garageKey);
            }
        }
        else if(inventory.contains(clothesPeg)&&!inventory.contains(room4Key)){
            System.out.println("the cupboard is locked");
        }
        else{
            System.out.println("the smell is to bad");
        }
        }
        else if(inventory.contains(garageKey)){
            System.out.println("you have the only item here");
        }else{
            System.out.println("come back if you change your mind");
        }
     String move = getUserInput();
     if(move.equals("south")){
          hall();
      }else{
         room4();
     }
    }
    
    public static void room5(){
        if(!inventory.contains(mirror)){
            wakeRoom1();
        }else{
            System.out.println("the thing seems to be scared of its reflection you see a key and take it. dashing out before the thing attacks you.");
            inventory.add(entranceKey);
            hall();
        }
    }
    
    public static void kitchen(){
        System.out.println("this kitchen is a mess has it ever been cleaned, there are doors on all 4 compas points");
        System.out.println("there could be useful objects would you like to take a look");
        String lookAround = getUserInput();
        if (lookAround.equals("yes")){
        if(!inventory.contains(clothesPeg)){
            System.out.println("there is a clothes peg would you like to pick it up?");
            String pickUp = getUserInput();
            if(pickUp.equals("yes")){
                inventory.add(clothesPeg);
            }
        }
        }
        else if(inventory.contains(clothesPeg)){
            System.out.println("you have the only item here");
        }else{
            System.out.println("come back if you change your mind");
        String move = getUserInput();
        if(move.equals("south")){
          hall();
      }
        else if(move.equals("west")){
          room3();
      }
        else if(move.equals("north")){
          backGarden();
      }
        else if(move.equals("east")){
          garage();
      }else{
            kitchen();
        }
    }
    }
    
    public static void entrance(){
        System.out.println("a door to the outside world is to your north, to go back to the hall go south");
        String move = getUserInput();
        if(move.equals("south")){
          hall();
      }
        else if(move.equals("north")&&!inventory.contains(entranceKey)){
          System.out.println("you must have a key to use this door go back to find it");
          hall();
      }
        else if(move.equals("north")&&inventory.contains(entranceKey)){
          escape();
      }else{
            entrance();
        }
    }
    
    public static void garage(){
        System.out.println("this is a garage with a big slidding door to the east, or the door you have just used to the south");
        System.out.println("there could be useful objects would you like to take a look");
        String lookAround = getUserInput();
        if (lookAround.equals("yes")){
        if(!inventory.contains(spade)){
            System.out.println("there is a spade would you like to pick it up?");
            String pickUp = getUserInput();
            if(pickUp.equals("yes")){
                inventory.add(spade);
            }
        }
        }
        else if(inventory.contains(spade)){
            System.out.println("you have the only item here");
        }else{
            System.out.println("come back if you change your mind");
        }
        String move = getUserInput();
        if(move.equals("south")){
          kitchen();
      }
        else if(move.equals("east")&& !inventory.contains(garageKey)){
          System.out.println("you need a key to use this door find one first");
          garage();
      }
        else if(move.equals("east")&& inventory.contains(garageKey)){
          escape();
      }else{
            garage();
        }
    }
    
    public static void backGarden(){
        System.out.println("fresh air at last but the fence is to hard to climb, the only door is south");
        System.out.println("there is a patch of dirt that as been move recently would you like to take a look");
        String lookAround = getUserInput();
        if (lookAround.equals("yes")){
        if(inventory.contains(spade)&&!inventory.contains(room4Key)){
            System.out.println("there is a key would you like to pick it up?");
            String pickUp = getUserInput();
            if(pickUp.equals("yes")){
                inventory.add(room4Key);
            }
        }
        }
        else if(inventory.contains(room4Key)){
            System.out.println("you have the only item here");
        }else{
            System.out.println("come back if you change your mind");
        }
        String move = getUserInput();
        if(move.equals("south")){
          kitchen();
      }else{
            backGarden();
        }
    }
    
    public static void escape(){
        System.out.println("you win");
    }
    
    public static void wakeRoom1(){
        System.out.println("what was that thing with the glowing red eyes it was scary. \n the door is to your north.");
        System.out.println("there could be useful objects would you like to take a look");
        String lookAround = getUserInput();
        if (lookAround.equals("yes")){
        if(!inventory.contains(mirror)){
            System.out.println("there is a mirror would you like to pick it up?");
            String pickUp = getUserInput();
            if(pickUp.equals("yes")){
                inventory.add(mirror);
            }
        }
        }
        else if(inventory.contains(mirror)){
            System.out.println("you have the only item here");
        }else{
            System.out.println("come back if you change your mind");
        }
        String move = getUserInput();
        if(move.equals("north")){
          hall();
      }else{
            room1();
        }
    }
    
}
