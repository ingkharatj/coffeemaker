package edu.ncsu.csc326.coffeemaker;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
public class InventoryTest {

    private Inventory inventory;

    private int coffee;
    private int chocolate;
    private int milk;
    private int sugar;


    @Before
    public void setUp(){
        inventory = new Inventory();
    }

    /**
     * Tests get/set Method for Coffee
     */
    @Test
    public void coffeeTest(){

        assertEquals(inventory.getCoffee(),15);

        inventory.setCoffee(25);
        assertEquals(inventory.getCoffee(),25);
        inventory.setCoffee(0);
        assertEquals(inventory.getCoffee(),0);
        inventory.setCoffee(100000);
        assertEquals(inventory.getCoffee(),100000);

    }

    /**
     * Tests get/set Method for milk
     */
    @Test
    public void milkTest(){

        assertEquals(inventory.getMilk(),15);

        inventory.setMilk(30);
        assertEquals(inventory.getMilk(),30);
        inventory.setMilk(0);
        assertEquals(inventory.getMilk(),0);
        inventory.setMilk(100000);
        assertEquals(inventory.getMilk(),100000);


    }

    /**
     * Tests get/set Method for sugar
     */
    @Test
    public void sugarTest(){

        assertEquals(inventory.getSugar(),15);

        inventory.setSugar(10);
        assertEquals(inventory.getSugar(), 10);
        inventory.setSugar(0);
        assertEquals(inventory.getSugar(), 0);
        inventory.setSugar(100000);
        assertEquals(inventory.getSugar(), 100000);

    }

    /**
     * Tests get/set Method for chocolate
     */
    @Test
    public void chocolateTest(){

        assertEquals(inventory.getChocolate(),15);

        inventory.setChocolate(20);
        assertEquals(inventory.getChocolate(), 20);
        inventory.setChocolate(0);
        assertEquals(inventory.getChocolate(), 0);
        inventory.setChocolate(100000);
        assertEquals(inventory.getChocolate(), 100000);

    }

    /**
     * Tests add Method for coffee
     */
    @Test
    public void addCoffee() throws InventoryException {

        try{
            inventory.addCoffee("ten");
            coffee = inventory.getCoffee();

        }catch (InventoryException e){

            assertNotSame("Units of coffee must be a positive integer",e);
//            System.out.println(e);

            assertTrue("Units of coffee must be a positive integer",coffee >= 0  );

        }
        try{
            inventory.addCoffee("-2");
            coffee = inventory.getCoffee();

        }catch (InventoryException e){

            assertTrue("Units of coffee must be a positive integer", coffee>=0);

        }

        inventory.addCoffee("5");
        coffee = inventory.getCoffee();
        assertEquals(coffee,20);

    }

    /**
     * Tests add Method for chocolate
     */
    @Test
    public void addChocolate() throws InventoryException {

        try{
            inventory.addChocolate("two");
            chocolate = inventory.getChocolate();

        }catch (InventoryException e){

            assertNotSame("Units of chocolate must be a positive integer",e);
//            System.out.println(e);

            assertTrue("Units of chocolate must be a positive integer",chocolate >= 0  );

        }
        try{
            inventory.addChocolate("-3");
            chocolate = inventory.getChocolate();

        }catch (InventoryException e){

            assertTrue("Units of coffee must be a positive integer", chocolate>=0);

        }

        inventory.addChocolate("6");
        chocolate = inventory.getChocolate();
        assertEquals(chocolate,21);

    }

    /**
     * Tests get/set Method for milk
     */
    @Test
    public void addMilk() throws InventoryException {

        try{
            inventory.addMilk("eight");
            milk = inventory.getMilk();

        }catch (InventoryException e){

            assertNotSame("Units of milk must be a positive integer",e);
//            System.out.println(e);

            assertTrue("Units of milk must be a positive integer",milk >= 0  );

        }
        try{
            inventory.addMilk("-3");
            milk = inventory.getMilk();

        }catch (InventoryException e){

            assertTrue("Units of milk must be a positive integer", milk>=0);

        }

        inventory.addMilk("7");
        milk = inventory.getMilk();
        assertEquals(milk,22);

    }

    /**
     * Tests add Method for sugar
     */
    @Test
    public void addSugar() throws InventoryException {

        try{
            inventory.addSugar("seven");
            sugar = inventory.getSugar();

        }catch (InventoryException e){

            assertNotSame("Units of sugar must be a positive integer",e);
//            System.out.println(e);

            assertTrue("Units of sugar must be a positive integer",sugar >= 0);

        }
        try{
            inventory.addSugar("-4");
            sugar = inventory.getSugar();

        }catch (InventoryException e){

            assertTrue("Units of sugar must be a positive integer", sugar>=0);

        }
        inventory.addSugar("7");
        sugar = inventory.getSugar();
        assertEquals(sugar,22);

    }






}
