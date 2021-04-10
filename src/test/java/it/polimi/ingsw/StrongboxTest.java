package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StrongboxTest {
    /**
     * Check of the correct initialisation of the values
     */
    @Test
    @DisplayName("Constructor Test")
    public void constructorTest() {
        Strongbox strongbox = new Strongbox();

        assertEquals(0, strongbox.getResource(Resource.COIN));
        assertEquals(0, strongbox.getResource(Resource.ROCK));
        assertEquals(0, strongbox.getResource(Resource.SERVANT));
        assertEquals(0, strongbox.getResource(Resource.SHIELD));
    }

    /**
     * Check of the correct behavior of addResource for each resource type
     */
    @Test
    @DisplayName("addResource Test")
    public void addResourceTest() {
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        assertEquals(0, strongbox.getResource(Resource.COIN));
        assertEquals(0, strongbox.getResource(Resource.ROCK));
        assertEquals(0, strongbox.getResource(Resource.SERVANT));
        assertEquals(0, strongbox.getResource(Resource.SHIELD));

        strongbox.addResource(Resource.COIN);

        assertEquals(1,strongbox.getResource(Resource.COIN));
        assertEquals(27, Reserve.getAmountOf(Resource.COIN));

        strongbox.addResource(Resource.ROCK);
        strongbox.addResource(Resource.ROCK);

        assertEquals(2,strongbox.getResource(Resource.ROCK));
        assertEquals(26, Reserve.getAmountOf(Resource.ROCK));

        strongbox.addResource(Resource.SHIELD);
        strongbox.addResource(Resource.SHIELD);
        strongbox.addResource(Resource.SHIELD);

        assertEquals(3,strongbox.getResource(Resource.SHIELD));
        assertEquals(25, Reserve.getAmountOf(Resource.SHIELD));

        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);

        assertEquals(4,strongbox.getResource(Resource.SERVANT));
        assertEquals(24, Reserve.getAmountOf(Resource.SERVANT));
    }

    /**
     * Check of the correct behavior of addResource for each resource type with
     * unavailable resources in reserve pool
     */
    @Test
    @DisplayName("addResource with unavailable resource Test")
    public void addResourceUnavailableTest() {
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        for (int i = 0; i < 28 ; i++){
            strongbox.addResource(Resource.COIN);

            assertEquals(1+i,strongbox.getResource(Resource.COIN));
            assertEquals(27-i, Reserve.getAmountOf(Resource.COIN));

            strongbox.addResource(Resource.ROCK);

            assertEquals(1+i,strongbox.getResource(Resource.ROCK));
            assertEquals(27-i, Reserve.getAmountOf(Resource.ROCK));

            strongbox.addResource(Resource.SHIELD);

            assertEquals(1+i,strongbox.getResource(Resource.SHIELD));
            assertEquals(27-i, Reserve.getAmountOf(Resource.SHIELD));

            strongbox.addResource(Resource.SERVANT);

            assertEquals(1+i,strongbox.getResource(Resource.SERVANT));
            assertEquals(27-i, Reserve.getAmountOf(Resource.SERVANT));

        }
        strongbox.addResource(Resource.COIN);

        assertEquals(28,strongbox.getResource(Resource.COIN));
        assertEquals(0, Reserve.getAmountOf(Resource.COIN));

        strongbox.addResource(Resource.ROCK);

        assertEquals(28,strongbox.getResource(Resource.ROCK));
        assertEquals(0, Reserve.getAmountOf(Resource.ROCK));

        strongbox.addResource(Resource.SERVANT);

        assertEquals(28,strongbox.getResource(Resource.SERVANT));
        assertEquals(0, Reserve.getAmountOf(Resource.SERVANT));

        strongbox.addResource(Resource.SHIELD);

        assertEquals(28,strongbox.getResource(Resource.SHIELD));
        assertEquals(0, Reserve.getAmountOf(Resource.SHIELD));

    }

    /**
     *Check of the correct behavior of useResource for each resource type with
     *available and unavailable resources
     */
    @Test
    @DisplayName("useResource Test")
    public void useResourceTest() {
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        strongbox.addResource(Resource.COIN);
        strongbox.addResource(Resource.COIN);

        assertEquals(2,strongbox.getResource(Resource.COIN));
        assertEquals(26, Reserve.getAmountOf(Resource.COIN));

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1,strongbox.getResource(Resource.COIN));
        assertEquals(27, Reserve.getAmountOf(Resource.COIN));

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.COIN));
        assertEquals(28, Reserve.getAmountOf(Resource.COIN));

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.COIN));
        assertEquals(28, Reserve.getAmountOf(Resource.COIN));

        strongbox.addResource(Resource.ROCK);
        strongbox.addResource(Resource.ROCK);

        assertEquals(2,strongbox.getResource(Resource.ROCK));
        assertEquals(26, Reserve.getAmountOf(Resource.ROCK));

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.ROCK));
        assertEquals(28, Reserve.getAmountOf(Resource.ROCK));

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.ROCK));
        assertEquals(28, Reserve.getAmountOf(Resource.ROCK));

        strongbox.addResource(Resource.SHIELD);
        strongbox.addResource(Resource.SHIELD);
        strongbox.addResource(Resource.SHIELD);

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SHIELD));
        assertEquals(28, Reserve.getAmountOf(Resource.SHIELD));

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SHIELD));
        assertEquals(28, Reserve.getAmountOf(Resource.SHIELD));

        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);

        assertEquals(4,strongbox.getResource(Resource.SERVANT));
        assertEquals(24, Reserve.getAmountOf(Resource.SERVANT));

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SERVANT));
        assertEquals(28, Reserve.getAmountOf(Resource.SERVANT));

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0,strongbox.getResource(Resource.SERVANT));
        assertEquals(28, Reserve.getAmountOf(Resource.SERVANT));
    }

    /**
     * Check of the correct return of the method resourceScore
     */
    @Test
    @DisplayName("resourceScore Test")
    public void resourceScoreTest(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        assertEquals(0, strongbox.resourceScore());

        strongbox.addResource(Resource.COIN);

        assertEquals(1, strongbox.resourceScore());

        strongbox.addResource(Resource.ROCK);
        strongbox.addResource(Resource.ROCK);

        assertEquals(3, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2, strongbox.resourceScore());

        strongbox.addResource(Resource.SHIELD);
        strongbox.addResource(Resource.SHIELD);
        strongbox.addResource(Resource.SHIELD);

        assertEquals(5, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, strongbox.resourceScore());

        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);
        strongbox.addResource(Resource.SERVANT);

        assertEquals(7, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.COIN);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(6, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.ROCK);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(5, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(4, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(3, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(2, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(1, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SERVANT);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0, strongbox.resourceScore());

        try{
            strongbox.useResource(Resource.SHIELD);
        } catch (UnavailableResourceException e) {
            e.printStackTrace();
        }

        assertEquals(0, strongbox.resourceScore());
    }


    @Test
    @DisplayName("availableResourcesTest 0")
    public void availableResourcesTest0(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        map.put(Resource.COIN, 3);
        map.put(Resource.ROCK, 3);
        map.put(Resource.SHIELD, 3);
        map.put(Resource.SERVANT, 3);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        available = strongbox.availableResources();

        for(Resource resource : available){
            if (availableMap.get(resource) == null){
                availableMap.put(resource,1);
            } else
                availableMap.put(resource, availableMap.remove(resource)+1);
        }

        assertTrue(map.equals(availableMap));
    }

    @Test
    @DisplayName("availableResourcesTest3")
    public void availableResourcesTest3(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        map.put(Resource.COIN, 0);
        map.put(Resource.ROCK, 0);
        map.put(Resource.SHIELD, 0);
        map.put(Resource.SERVANT, 0);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),0);
        assertEquals(availableMap.get(Resource.SERVANT),0);
    }

    @Test
    @DisplayName("availableResourcesTest4 : available only resources")
    public void availableResourcesTest4(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        map.put(Resource.COIN, 10);
        map.put(Resource.ROCK, 1);
        map.put(Resource.SHIELD, 2);
        map.put(Resource.SERVANT, 3);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(availableMap.get(Resource.COIN),10);
        assertEquals(availableMap.get(Resource.ROCK),1);
        assertEquals(availableMap.get(Resource.SHIELD),2);
        assertEquals(availableMap.get(Resource.SERVANT),3);
    }


    @Test
    @DisplayName("availableResourcesTest5 : one unavailable resource type")
    public void availableResourcesTest5(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        map.put(Resource.COIN, 0);
        map.put(Resource.ROCK, 0);
        map.put(Resource.SHIELD, 0);
        map.put(Resource.SERVANT, 29);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),0);
        assertEquals(availableMap.get(Resource.SERVANT),28);
    }


    @Test
    @DisplayName("availableResourcesTest6 : all to limits")
    public void availableResourcesTest6(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        map.put(Resource.COIN, 28);
        map.put(Resource.ROCK, 28);
        map.put(Resource.SHIELD, 28);
        map.put(Resource.SERVANT, 28);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(availableMap.get(Resource.COIN),28);
        assertEquals(availableMap.get(Resource.ROCK),28);
        assertEquals(availableMap.get(Resource.SHIELD),28);
        assertEquals(availableMap.get(Resource.SERVANT),28);
    }

    @Test
    @DisplayName("availableResourcesTest7 : all out of limit")
    public void availableResourcesTest7(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();

        ArrayList<Resource> available;

        map.put(Resource.COIN, 100);
        map.put(Resource.ROCK, 74);
        map.put(Resource.SHIELD, 55);
        map.put(Resource.SERVANT, 53);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        assertEquals(availableMap.get(Resource.COIN),28);
        assertEquals(availableMap.get(Resource.ROCK),28);
        assertEquals(availableMap.get(Resource.SHIELD),28);
        assertEquals(availableMap.get(Resource.SERVANT),28);
    }

    @Test
    @DisplayName("PayResources Test - simple test")
    public void payResourcesTest0(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> unpaidMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> unpaid;

        ArrayList<Resource> cost = new ArrayList<>();

        map.put(Resource.COIN, 0);
        map.put(Resource.ROCK, 0);
        map.put(Resource.SHIELD, 0);
        map.put(Resource.SERVANT, 0);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        costMap.put(Resource.COIN, 1);
        costMap.put(Resource.ROCK, 1);
        costMap.put(Resource.SHIELD, 1);
        costMap.put(Resource.SERVANT, 1);

        unpaidMap.put(Resource.COIN, 0);
        unpaidMap.put(Resource.ROCK, 0);
        unpaidMap.put(Resource.SHIELD, 0);
        unpaidMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }
        unpaid = strongbox.payResources(cost);
        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        for (Resource r : unpaid) {
            unpaidMap.put(r,unpaidMap.remove(r)+1);
        }

        assertEquals(unpaidMap.get(Resource.COIN),1);
        assertEquals(unpaidMap.get(Resource.ROCK),1);
        assertEquals(unpaidMap.get(Resource.SHIELD),1);
        assertEquals(unpaidMap.get(Resource.SERVANT),1);

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),0);
        assertEquals(availableMap.get(Resource.SERVANT),0);

    }

    @Test
    @DisplayName("PayResources Test 1- affordable cost")
    public void payResourcesTest1(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> unpaidMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> unpaid;

        ArrayList<Resource> cost = new ArrayList<>();

        map.put(Resource.COIN, 8);
        map.put(Resource.ROCK, 8);
        map.put(Resource.SHIELD, 8);
        map.put(Resource.SERVANT, 8);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        costMap.put(Resource.COIN, 1);
        costMap.put(Resource.ROCK, 1);
        costMap.put(Resource.SHIELD, 1);
        costMap.put(Resource.SERVANT, 1);

        unpaidMap.put(Resource.COIN, 0);
        unpaidMap.put(Resource.ROCK, 0);
        unpaidMap.put(Resource.SHIELD, 0);
        unpaidMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        unpaid = strongbox.payResources(cost);
        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        for (Resource r : unpaid) {
            unpaidMap.put(r,unpaidMap.remove(r)+1);
        }

        assertEquals(unpaidMap.get(Resource.COIN),0);
        assertEquals(unpaidMap.get(Resource.ROCK),0);
        assertEquals(unpaidMap.get(Resource.SHIELD),0);
        assertEquals(unpaidMap.get(Resource.SERVANT),0);

        assertEquals(availableMap.get(Resource.COIN),7);
        assertEquals(availableMap.get(Resource.ROCK),7);
        assertEquals(availableMap.get(Resource.SHIELD),7);
        assertEquals(availableMap.get(Resource.SERVANT),7);

    }

    @Test
    @DisplayName("PayResources Test 2- affordable cost")
    public void payResourcesTest2(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> unpaidMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> unpaid;

        ArrayList<Resource> cost = new ArrayList<>();

        map.put(Resource.COIN, 1);
        map.put(Resource.ROCK, 0);
        map.put(Resource.SHIELD, 2);
        map.put(Resource.SERVANT, 3);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        costMap.put(Resource.COIN, 1);
        costMap.put(Resource.ROCK, 1);
        costMap.put(Resource.SHIELD, 1);
        costMap.put(Resource.SERVANT, 1);

        unpaidMap.put(Resource.COIN, 0);
        unpaidMap.put(Resource.ROCK, 0);
        unpaidMap.put(Resource.SHIELD, 0);
        unpaidMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        unpaid = strongbox.payResources(cost);
        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        for (Resource r : unpaid) {
            unpaidMap.put(r,unpaidMap.remove(r)+1);
        }

        assertEquals(unpaidMap.get(Resource.COIN),0);
        assertEquals(unpaidMap.get(Resource.ROCK),1);
        assertEquals(unpaidMap.get(Resource.SHIELD),0);
        assertEquals(unpaidMap.get(Resource.SERVANT),0);

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),1);
        assertEquals(availableMap.get(Resource.SERVANT),2);

    }

    @Test
    @DisplayName("PayResources Test 3 ")
    public void payResourcesTest3(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> unpaidMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> unpaid;

        ArrayList<Resource> cost = new ArrayList<>();

        map.put(Resource.COIN, 0);
        map.put(Resource.ROCK, 0);
        map.put(Resource.SHIELD, 0);
        map.put(Resource.SERVANT, 0);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        costMap.put(Resource.COIN, 4);
        costMap.put(Resource.ROCK, 15);
        costMap.put(Resource.SHIELD, 9);
        costMap.put(Resource.SERVANT, 1);

        unpaidMap.put(Resource.COIN, 0);
        unpaidMap.put(Resource.ROCK, 0);
        unpaidMap.put(Resource.SHIELD, 0);
        unpaidMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        unpaid = strongbox.payResources(cost);
        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        for (Resource r : unpaid) {
            unpaidMap.put(r,unpaidMap.remove(r)+1);
        }

        assertEquals(unpaidMap.get(Resource.COIN),4);
        assertEquals(unpaidMap.get(Resource.ROCK),15);
        assertEquals(unpaidMap.get(Resource.SHIELD),9);
        assertEquals(unpaidMap.get(Resource.SERVANT),1);

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),0);
        assertEquals(availableMap.get(Resource.SERVANT),0);

    }

    @Test
    @DisplayName("PayResources Test 4 ")
    public void payResourcesTest4(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> unpaidMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> unpaid;

        ArrayList<Resource> cost = new ArrayList<>();

        map.put(Resource.COIN, 10);
        map.put(Resource.ROCK, 10);
        map.put(Resource.SHIELD, 10);
        map.put(Resource.SERVANT, 10);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        costMap.put(Resource.COIN, 4);
        costMap.put(Resource.ROCK, 15);
        costMap.put(Resource.SHIELD, 9);
        costMap.put(Resource.SERVANT, 1);

        unpaidMap.put(Resource.COIN, 0);
        unpaidMap.put(Resource.ROCK, 0);
        unpaidMap.put(Resource.SHIELD, 0);
        unpaidMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        unpaid = strongbox.payResources(cost);
        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        for (Resource r : unpaid) {
            unpaidMap.put(r,unpaidMap.remove(r)+1);
        }

        assertEquals(unpaidMap.get(Resource.COIN),0);
        assertEquals(unpaidMap.get(Resource.ROCK),5);
        assertEquals(unpaidMap.get(Resource.SHIELD),0);
        assertEquals(unpaidMap.get(Resource.SERVANT),0);

        assertEquals(availableMap.get(Resource.COIN),6);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),1);
        assertEquals(availableMap.get(Resource.SERVANT),9);

    }

    @Test
    @DisplayName("PayResources Test 5 ")
    public void payResourcesTest5(){
        Strongbox strongbox = new Strongbox();
        Reserve reserve = new Reserve();

        Map<Resource,Integer> map = new HashMap<>();
        Map<Resource,Integer> availableMap = new HashMap<>();
        Map<Resource,Integer> costMap = new HashMap<>();
        Map<Resource,Integer> unpaidMap = new HashMap<>();

        ArrayList<Resource> available;
        ArrayList<Resource> unpaid;

        ArrayList<Resource> cost = new ArrayList<>();

        map.put(Resource.COIN, 10);
        map.put(Resource.ROCK, 10);
        map.put(Resource.SHIELD, 10);
        map.put(Resource.SERVANT, 10);

        availableMap.put(Resource.COIN, 0);
        availableMap.put(Resource.ROCK, 0);
        availableMap.put(Resource.SHIELD, 0);
        availableMap.put(Resource.SERVANT, 0);

        costMap.put(Resource.COIN, 20);
        costMap.put(Resource.ROCK, 15);
        costMap.put(Resource.SHIELD, 4);
        costMap.put(Resource.SERVANT, 0);

        unpaidMap.put(Resource.COIN, 0);
        unpaidMap.put(Resource.ROCK, 0);
        unpaidMap.put(Resource.SHIELD, 0);
        unpaidMap.put(Resource.SERVANT, 0);

        for(Resource key : map.keySet()){
            for (int i = 0; i<map.get(key); i++){
                strongbox.addResource(key);
            }
        }

        for(Resource key : costMap.keySet()){
            for (int i = 0; i<costMap.get(key); i++){
                cost.add(key);
            }
        }

        unpaid = strongbox.payResources(cost);
        available = strongbox.availableResources();

        for (Resource r : available) {
            availableMap.put(r,availableMap.remove(r)+1);
        }

        for (Resource r : unpaid) {
            unpaidMap.put(r,unpaidMap.remove(r)+1);
        }

        assertEquals(unpaidMap.get(Resource.COIN),10);
        assertEquals(unpaidMap.get(Resource.ROCK),5);
        assertEquals(unpaidMap.get(Resource.SHIELD),0);
        assertEquals(unpaidMap.get(Resource.SERVANT),0);

        assertEquals(availableMap.get(Resource.COIN),0);
        assertEquals(availableMap.get(Resource.ROCK),0);
        assertEquals(availableMap.get(Resource.SHIELD),6);
        assertEquals(availableMap.get(Resource.SERVANT),10);

    }


}
