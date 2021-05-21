package it.polimi.ingsw.client.view.cli;

import it.polimi.ingsw.client.commands.Command;
import it.polimi.ingsw.client.commands.InvalidCommandException;
import it.polimi.ingsw.client.commands.SpentTokenException;
import it.polimi.ingsw.client.lightModel.lightGameBoard.LightLeaderCards;
import it.polimi.ingsw.client.lightModel.productionCards.LightProductionCards;
import it.polimi.ingsw.client.ligtModelNotification.*;
import it.polimi.ingsw.client.view.View;
import it.polimi.ingsw.client.view.ViewController;
import it.polimi.ingsw.client.view.ViewControllerObservable;
import it.polimi.ingsw.messages.*;
import it.polimi.ingsw.messages.observable.ShowAllOfPlayerMessage;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.leaderCards.LeaderCard;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Cli extends ViewControllerObservable implements View, NotificatorVisitor {
    private ViewController viewController;

    private Scanner input = new Scanner(System.in);

    //private final static int offset = 20;


    /*public Cli(){

    }*/


    public void readCommand(){

        (new Thread( () -> {
                                try {
                                    Message msg = (Command.parseCommand(input.nextLine(),this.viewController)).commandOn();
                                    if (msg != null) {
                                        this.notifyObserver(msg);
                                    } else
                                        readCommand();
                                } catch (InvalidCommandException e) {
                                    System.out.println("Invalid command, type 'help' to check the command list");
                                    readCommand();
                                } catch (InterruptedException | IOException e) {
                                    e.printStackTrace();
                                } catch (SpentTokenException e) {
                                    System.out.println("Impossible request, you have already done an action");
                                }
        }
                    )
        ).start();

    }



    @Override
    public void setViewController(ViewController viewController){
        this.viewController=viewController;
        setObserver(viewController);
    }

    @Override
    public void startView() {
        System.out.println("Welcome to MASTERS OF THE RENAISSANCE!");
    }

    @Override
    public void update(String notification) throws IOException, InterruptedException {
        Notification parsedMsg = Notification.deserialize(notification);
        parsedMsg.accept(this);
    }

    @Override
    public void visit(DeckListNotification deckListNotification) {
        
        int spaces = 42;
        int chars;
        String temp;
        System.out.println("Production card decks:" );

        System.out.print("               green" +
                "                                    blue" +
                "                                    yellow" +
                "                                    violet\n");

        for(int i = 0;i<3;i++){
            System.out.println("\nLevel "+(3-i)+":");


            //-----------------------------------
            System.out.print("        ");
            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            System.out.println("");

            //---------------------------

            System.out.print("        ");
            temp = "| c= " + deckListNotification.getListOfFirstCard().get(5-i).getCost();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }


            temp = "| c= " + deckListNotification.getListOfFirstCard().get(2-i).getCost();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| c= " + deckListNotification.getListOfFirstCard().get(8-i).getCost();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| c= " + deckListNotification.getListOfFirstCard().get(11-i).getCost();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println("");



            //-----------------------------------

            System.out.print("        ");
            temp = "| i= " + deckListNotification.getListOfFirstCard().get(5-i).getIn().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| i= " + deckListNotification.getListOfFirstCard().get(2-i).getIn().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| i= " + deckListNotification.getListOfFirstCard().get(8-i).getIn().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| i= " + deckListNotification.getListOfFirstCard().get(11-i).getIn().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }
            System.out.print("|");
                System.out.println("");
            //-------------------------------------------------
            System.out.print("        ");
            temp = "| o= " + deckListNotification.getListOfFirstCard().get(5-i).getOut().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| o= " + deckListNotification.getListOfFirstCard().get(2-i).getOut().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| o= " + deckListNotification.getListOfFirstCard().get(8-i).getOut().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| o= " + deckListNotification.getListOfFirstCard().get(11-i).getOut().toString();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println("");
            //-----------------------------------------
            System.out.print("        ");
            temp = "| faith points= " + deckListNotification.getListOfFirstCard().get(5-i).isFaithPoint();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| faith points= " + deckListNotification.getListOfFirstCard().get(2-i).isFaithPoint();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| faith points= " + deckListNotification.getListOfFirstCard().get(8-i).isFaithPoint();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| faith points= " + deckListNotification.getListOfFirstCard().get(11-i).isFaithPoint();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println("");
            //---------------------------------------
            System.out.print("        ");
            temp = "| victory points= " + deckListNotification.getListOfFirstCard().get(5-i).getPoints();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| victory points= " + deckListNotification.getListOfFirstCard().get(2-i).getPoints();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| victory points= " + deckListNotification.getListOfFirstCard().get(8-i).getPoints();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }

            temp = "| victory points= " + deckListNotification.getListOfFirstCard().get(11-i).getPoints();
            chars = temp.length();
            System.out.print(temp);
            for(int k = 0;k<spaces-chars;k++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println("");

            //----------------------------------
            System.out.print("        ");
            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            System.out.println("");

        }
    }

    @Override
    public void visit(GameboardListNotification gameboardListNotification) {
        int spaces = 50;
        int chars;
        String temp;
        System.out.println("Production cards of your game board:" );

        //-----------------------------------
        System.out.print("        ");
        for(int k = 0;k<spaces;k++){
            System.out.print("-");
        }

        for(int k = 0;k<spaces;k++){
            System.out.print("-");
        }

        for(int k = 0;k<spaces;k++){
            System.out.print("-");
        }

        System.out.println("");

        //---------------------------
        for(int i = 0 ; i < 3; i++) {
            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| level= " + gameboardListNotification.getListOfFirstCard()[i][0].getLevel();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| level= " + gameboardListNotification.getListOfFirstCard()[i][1].getLevel();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| level= " + gameboardListNotification.getListOfFirstCard()[i][2].getLevel();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            //-----------------------------------


            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| colour= " + gameboardListNotification.getListOfFirstCard()[i][0].getColour().getColour();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| colour= " + gameboardListNotification.getListOfFirstCard()[i][1].getColour().getColour();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| colour= " + gameboardListNotification.getListOfFirstCard()[i][2].getColour().getColour();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| cost= " + gameboardListNotification.getListOfFirstCard()[i][0].getCost().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| cost= " + gameboardListNotification.getListOfFirstCard()[i][1].getCost().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| cost= " + gameboardListNotification.getListOfFirstCard()[i][2].getCost().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| i= " + gameboardListNotification.getListOfFirstCard()[i][0].getIn().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| i= " + gameboardListNotification.getListOfFirstCard()[i][1].getIn().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| i= " + gameboardListNotification.getListOfFirstCard()[i][2].getIn().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| o= " + gameboardListNotification.getListOfFirstCard()[i][0].getOut().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| o= " + gameboardListNotification.getListOfFirstCard()[i][1].getOut().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| o= " + gameboardListNotification.getListOfFirstCard()[i][2].getOut().toString();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| faith points= " + gameboardListNotification.getListOfFirstCard()[i][0].isFaithPoint();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| faith points= " + gameboardListNotification.getListOfFirstCard()[i][1].isFaithPoint();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| faith points= " + gameboardListNotification.getListOfFirstCard()[i][2].isFaithPoint();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            //-----------------------------------

            System.out.print("        ");
            if (gameboardListNotification.getListOfFirstCard()[i][0] != null) {
                temp = "| victory points= " + gameboardListNotification.getListOfFirstCard()[i][0].getPoints();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][1] != null) {
                temp = "| victory points= " + gameboardListNotification.getListOfFirstCard()[i][1].getPoints();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }

            if (gameboardListNotification.getListOfFirstCard()[i][2] != null) {
                temp = "| victory points= " + gameboardListNotification.getListOfFirstCard()[i][2].getPoints();
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            } else {
                temp = "| ";
                chars = temp.length();
                System.out.print(temp);
                for (int k = 0; k < spaces - chars; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print("|");

            System.out.println("");

            System.out.print("        ");
            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            for(int k = 0;k<spaces;k++){
                System.out.print("-");
            }

            System.out.println("");
        }
    }

    @Override
    public void visit(LeaderListCardNotification leaderListCardNotification) {
        if(leaderListCardNotification.isActivated())
            System.out.println("The leader cards you activated: ");
        else
            System.out.println("The leader cards you can activate or discard: ");

        for(int i = 0; i < leaderListCardNotification.getListOfFirstCard().size(); i++){
            System.out.print("        ");
            System.out.println("--------------------------------------------------------------------------------------------");

            System.out.print("        ");
            System.out.println( i+1 + " leader card");

            System.out.print("        ");
            System.out.println(leaderListCardNotification.getListOfFirstCard().get(i).getRequirements().toString());

            System.out.print("        ");
            System.out.println(leaderListCardNotification.getListOfFirstCard().get(i).toString());

            System.out.print("        ");
            System.out.print("Victory points: ");
            System.out.println(leaderListCardNotification.getListOfFirstCard().get(i).getPoints());
        }
        System.out.print("        ");
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    @Override
    public void visit(StorageNotification storageNotification) {
        System.out.println("Your storage now contains: " + storageNotification.getMap());
    }

    @Override
    public void visit(StrongboxNotification strongboxNotification) {
        System.out.println("Your strongbox now contains: " + strongboxNotification.getMap());
    }

    @Override
    public void visit(ReserveNotification reserveNotification) {
        System.out.println("The reserve now contains: " + reserveNotification.getMap());
    }

    @Override
    public void visit(MarketNotification marketNotification) {
        int spaces = 10;
        int chars;
        String temp;
        System.out.println("The market now is: ");

        //-----------------------------------
        System.out.print("        ");
        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        System.out.println("");

        //---------------------------

        for (int i = 0; i < 3; i++) {
            System.out.print("        ");

            temp = "| " + marketNotification.getList()[i][0].getColour();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }

            temp = "| " + marketNotification.getList()[i][1].getColour();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }

            temp = "| " + marketNotification.getList()[i][2].getColour();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }

            temp = "| " + marketNotification.getList()[i][3].getColour();
            chars = temp.length();
            System.out.print(temp);
            for (int k = 0; k < spaces - chars; k++) {
                System.out.print(" ");
            }
            System.out.print("|");

            System.out.println("");
        }

        System.out.print("        ");
        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        for (int k = 0; k < spaces; k++) {
            System.out.print("-");
        }

        System.out.println("");

    }

    @Override
    public void visit(ExtraMarketNotification extraMarketNotification) {
        System.out.println("The extra marble of the market now is: " + extraMarketNotification.getMarble().getColour());
    }

    @Override
    public void visit(ActivateNotification activateNotification) {

    }

    @Override
    public void visit(FaithPathNotification faithPathNotification) {
        System.out.println("Your faith indicator position in the faith track is: " + faithPathNotification.getI());
    }


    @Override
    public void notifyError(Message msg) {
        System.out.println(msg.toString());
    }

    @Override
    public void askNumberOfPlayers() throws IOException, InterruptedException {
        int nOfPlayers;
        System.out.println("How many players? [1...4]");
        while (input.hasNextInt()){
            nOfPlayers =input.nextInt();
            if (nOfPlayers > 0 && nOfPlayers < 5){
                notifyObserver(new NumberPlayerMessage(nOfPlayers));
                if(nOfPlayers > 1)
                    System.out.println("Please wait for the missing players to start the game...");
                return;
            } else {
                System.out.println("Invalid number of players, try with a number between 1 and 4");
            }
        }
    }


    @Override
    public void askNickname() throws IOException, InterruptedException {
        String nickname;
        System.out.println("What's your username?");
        if (input.hasNextLine()){
            nickname =input.nextLine();
            viewController.setNickName(nickname);
            notifyObserver(new UsernameMessage(nickname));
        }
    }
    @Override
    public void askRestartGame() throws IOException, InterruptedException {
        String answer;
        System.out.println("Do you want to resume the previous match? [yes / no]");
        while (input.hasNextLine()){
            answer =input.nextLine();
            if (answer.equals("yes")){
                notifyObserver(new RestartAnswerMessage(true));
                return;
            } else if (answer.equals("no")){
                notifyObserver(new RestartAnswerMessage(false));
                return;
            } else {
                System.out.println("Invalid command, try again");
            }
        }
    }
    @Override
    public void yourTurn() {

        System.out.println("It's your turn");
    }

    @Override
    public void showChangeCurrent(String currentNick) {
        System.out.println("Current player: "+currentNick);
    }

    @Override
    public void showPlayersOrder(ArrayList<String> nickName){
        System.out.println("The players round is : " + nickName);
    }

    @Override
    public void showLastTurn(String nickName){
        System.out.println("Player " + nickName + " activated the last turn round");
    }
    @Override
    public void showLobby(int playersInLobby, int playerInGame){
        System.out.println("There are " + playersInLobby + " players in the lobby out of " + playerInGame +
                ", waiting for the missing players to start the game...");
    }
    @Override
    public void askLeaderCardToKeep(ArrayList<LeaderCard> leaderCards){
        System.out.println("Please choose 2 from the following leader cards to keep in your game board : " + leaderCards);
    }
    @Override
    public void showCallForCouncil(String nickname, int papalCard){
        if(papalCard == 0){
            System.out.println("Player " + nickname + "activated the report in the Vatican : sorry, you didn't get the papal favor card");
        }else if (papalCard == 1){
            System.out.println("Player " + nickname + "activated the report in the Vatican : you got the papal favor card!");
        }
    }

    @Override
    public void showStartGame() {
        System.out.println("The game has started!");
    }

    @Override
    public void showRestartMessage() {
        System.out.println("Enter your username of the previous game to resume the match...");
    }

    @Override
    public void showPlayerInfo(ShowAllOfPlayerMessage msg) {
        System.out.println(msg.getNickname());
        System.out.println(msg.isConnected());
        int[][] productioncard=msg.getProductioncard();
        for (int i=0; i<3;i++)
            for (int j=0; i<3;i++)
                if (productioncard[i][j]==0)
                    System.out.println("");
                else
                    System.out.println(LightProductionCards.productionCardByKey(productioncard[i][j]));
        ArrayList<Integer> listLeaderActivated=msg.getListLeaderActivated();
        for (int i=0; i<listLeaderActivated.size();i++)
            System.out.println(LightLeaderCards.leaderCardByKey(listLeaderActivated.get(i)));

        System.out.println(msg.getStrongBox());
        System.out.println(msg.getStorage());
        System.out.println(msg.getFaithIndicator());
    }
}