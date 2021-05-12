package it.polimi.ingsw;

import it.polimi.ingsw.server.model.GameMultiPlayer;
import it.polimi.ingsw.server.model.Resource;
import it.polimi.ingsw.server.model.colours.*;
import it.polimi.ingsw.server.model.leaderCards.*;
import it.polimi.ingsw.server.model.productionCards.DeckProductionCardTwoYellow;
import it.polimi.ingsw.server.model.productionCards.ProductionCard;
import it.polimi.ingsw.server.model.requirements.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class observerTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> nickname = new ArrayList<>(2);
        nickname.add("aa");
        nickname.add("ii");

        GameMultiPlayer gameMultiPlayer3 = new GameMultiPlayer(2, nickname, true);
    }
}

