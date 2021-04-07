package it.polimi.ingsw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FaithPathTest {

    /**
     * Correct standard construction check
     */
    @Test
    @DisplayName("defaultConstructorTest")
    public void defaultConstructorTest() {

        FaithPath faithPath = new FaithPath ();

        assertEquals(faithPath.getIndicator(), 0);
        assertEquals(faithPath.getCurrCall(), 0);

    }

    /**
     * Correct initialised construction check
     */
    @Test
    @DisplayName("initialisedtConstructorTest")
    public void initialisedConstructorTest() {

        FaithPath faithPath = new FaithPath (4);

        assertEquals(faithPath.getIndicator(), 4);
        assertEquals(faithPath.getCurrCall(), 0);

    }

    /**
     * Correct position counter increase check (within path limits)
     */
    @Test
    @DisplayName("moveTest")
    public void moveTest() {

        FaithPath faithPath = new FaithPath ();

        for (int i = 0; i<24 ; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }

        }
    }


    /**
     * Test for papal card assignment in case of papal event caller
     */
    @Test
    @DisplayName("setPapalTest : only caller settings")
    public void setPapalTest1() {

        FaithPath faithPath = new FaithPath ();

        for (int i = 0,j = 0; i< 24; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
                assertEquals(faithPath.getCurrCall(), j);
                faithPath.setPapal();
                assertEquals(faithPath.getPapalCard(j), 1);
                assertEquals(faithPath.getCurrCall(), ++j);

            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }

        }

    }

    /**
     * Papal card assignment test in case of only valid position within vatican spaces
     */
    @Test
    @DisplayName("setPapalTest : only valid settings")
    public void setPapalTest2() {

        FaithPath faithPath = new FaithPath ();
        int j = 0;

        for (int i = 0; i< 6; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 1);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 6; i< 14; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 1);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 14; i< 20; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 1);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 20; i< 24; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        for (int i = 24; i< 30; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), 24);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

    }

    /**
     * Correct papal card assignment test in a general game situation
     */
    @Test
    @DisplayName("setPapalTest : mixed settings")
    public void setPapalTest3() {

        FaithPath faithPath = new FaithPath ();
        int j = 0;

        for (int i = 0; i< 3; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 0);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 3; i< 14; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 1);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 14; i< 18; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 0);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 18; i< 24; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        for (int i = 24; i< 30; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), 24);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

    }

    /**
     * Test for best faithPath score evaluation
     */
    @Test
    @DisplayName("faithScoreTest : all papalCards and last position")
    public void faithScoreTest1() {

        FaithPath faithPath = new FaithPath ();
        int j = 0;
        int score;
        for (int i = 0; i< 24; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
                assertEquals(faithPath.getCurrCall(), j);
                faithPath.setPapal();
                assertEquals(faithPath.getPapalCard(j), 1);
                assertEquals(faithPath.getCurrCall(), ++j);

            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        score = faithPath.faithScore();
        assertEquals( score, 2+3+4+20);

    }

    /**
     * No points evaluation test
     */
    @Test
    @DisplayName("faithScoreTest : unusual game")
    public void faithScoreTest2() {

        FaithPath faithPath = new FaithPath ();

        int score;

        score = faithPath.faithScore();
        assertEquals( score, 0);

    }

    /**
     * Score evaluation in case of only a movement
     */
    @Test
    @DisplayName("faithScoreTest : only position - 1")
    public void faithScoreTest3() {

        FaithPath faithPath = new FaithPath ();

        int score;

        try {
            faithPath.move();
            assertEquals(faithPath.getIndicator(), 1);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }

        score = faithPath.faithScore();

        assertEquals( score, 0);

    }

    /**
     * Score evaluation in case of only two movements
     */
    @Test
    @DisplayName("faithScoreTest : only position - 2")
    public void faithScoreTest5() {

        FaithPath faithPath = new FaithPath ();

        int score;

        for (int i = 0; i< 2; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
        }

        score = faithPath.faithScore();

        assertEquals( score, 0);

    }

    /**
     * Score evaluation check in every possible position without papal card points
     */
    @Test
    @DisplayName("faithScoreTest : only position - 0 .. 24")
    public void faithScoreTest6() {

        FaithPath faithPath = new FaithPath ();

        int score;

        for (int i = 0; i< 2; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 0);
        }

        for (int i = 2; i< 5; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 1);
        }

        for (int i = 5; i< 8; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 2);
        }

        for (int i = 8; i< 11; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 4);
        }

        for (int i = 11; i< 14; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            }catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 6);
        }

        for (int i = 14; i< 17; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 9);
        }

        for (int i = 17; i< 20; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 12);
        }

        for (int i = 20; i< 23; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            }catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 16);
        }

        for (int i = 24; i< 30; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), 24);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 20);
        }

    }

    /**
     * Score evaluation check in every possible position with a common papal card assignment
     */
    @Test
    @DisplayName("faithScoreTest : papalCards and position - 0 .. 24")
    public void faithScoreTest7() {

        FaithPath faithPath = new FaithPath ();
        int j = 0;
        int score;

        for (int i = 0; i< 2; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 0);
        }
        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 0);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 2; i< 5; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 1);
        }


        for (int i = 5; i< 8; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 2);
        }

        for (int i = 8; i< 11; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 4);
        }

        for (int i = 11; i< 14; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 6 );
        }
        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 1);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 14; i< 17; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 9 + 3);
        }

        for (int i = 17; i< 20; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 12 + 3);
        }

        assertEquals(faithPath.getCurrCall(), j);
        faithPath.setPapal();
        assertEquals(faithPath.getPapalCard(j), 1);
        assertEquals(faithPath.getCurrCall(), ++j);

        for (int i = 20; i< 23; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), i+1);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 16 + 7);
        }

        for (int i = 24; i< 30; i++){
            try {
                faithPath.move();
                assertEquals(faithPath.getIndicator(), 24);
            } catch (CallForCouncilException c) {
                System.out.println("CallForCouncilException Thrown");
            } catch (LastSpaceReachedException e) {
                System.out.println("Partita Terminata");
            }
            score = faithPath.faithScore();
            assertEquals( score, 20 + 7);
        }

    }

    /**
     * test for control the functionality and the correcteness of move in faithpath and red marble call
     */
    @Test
    @DisplayName("faithScoreTest : only position - 2")
    public void faithWithUseOfRedMarble() throws CallForCouncilException {

        Game game = new Game();
        Player player = new Player(game);
        RedMarble redMarble = new RedMarble();

        assertEquals(player.getIndicator(), 0);
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        assertEquals(player.getIndicator(), 1);
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        assertEquals(player.getIndicator(), 3);
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        assertEquals(player.getIndicator(), 5);
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        try {
            redMarble.giveResource(player);
        } catch (CallForCouncilException c) {
            System.out.println("CallForCouncilException Thrown");
        } catch (LastSpaceReachedException e) {
            System.out.println("Partita Terminata");
        }
        assertEquals(player.getIndicator(), 8);
    }
















}