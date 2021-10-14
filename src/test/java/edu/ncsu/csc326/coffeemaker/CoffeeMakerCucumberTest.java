package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;


public class CoffeeMakerCucumberTest {

    private CoffeeMaker coffeeMaker;

    private Inventory inventory;

    private int coffee;
    private int chocolate;
    private int milk;
    private int sugar;

    private int money;
    private int index;
    private int change;

    private Recipe recipe1;
    private Recipe recipe2;

    private static Recipe CreateRecipe(String name, String amtChocolate, String amtCoffee, String amtMilk, String amtSugar, String price) throws RecipeException {

        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setAmtChocolate("0");
        recipe.setAmtCoffee("3");
        recipe.setAmtMilk("1");
        recipe.setAmtSugar("1");
        recipe.setPrice("75");

        return  recipe;

    }

    @Given("Create a recipe")
    public void CreateRecipe() {
        coffeeMaker = new CoffeeMaker();
    }

    @When("I add Latte recipe to coffee maker")
    public void AddRecipe() throws RecipeException {

        recipe1 = CreateRecipe("Latte","0","3","3","1","100");
        coffeeMaker.addRecipe(recipe1);
    }

    @Then("the coffee maker must have Latte recipe")
    public void CheckRecipe(){
        assertEquals(coffeeMaker.getRecipes()[0].getName(),"Latte");
        assertEquals(coffeeMaker.getRecipes()[0].getAmtChocolate(),0);
        assertEquals(coffeeMaker.getRecipes()[0].getAmtCoffee(), 3);
        assertEquals(coffeeMaker.getRecipes()[0].getAmtMilk(), 1);
        assertEquals(coffeeMaker.getRecipes()[0].getAmtSugar(), 1);
        assertEquals(coffeeMaker.getRecipes()[0].getPrice(), 75);

    }

    @Given("coffee maker has Latte recipe")
    public void LatteRecipe() throws RecipeException {
        coffeeMaker = new CoffeeMaker();
        recipe1 = CreateRecipe("Latte","0","3","3","1","100");
        coffeeMaker.addRecipe(recipe1);
    }

    @When("I edit Latte recipe to Milktea")
    public void EditRecipe(){
        coffeeMaker.deleteRecipe(0);
    }

    @Then("that Latte recipe will Milktea")
    public void MilkTeaRecipe() throws RecipeException {
        recipe2 = CreateRecipe("Milktea","7","6","5","2","60");

        coffeeMaker.editRecipe(0, recipe2);

        assertSame(recipe2, coffeeMaker.getRecipes()[0]);
    }

    @Given("Inventory")
    public void Inventory() {
        inventory = new Inventory();
    }

    @When("I add {int} coffee into inventory")
    public void AddCoffee(int n) throws InventoryException {
        inventory.addCoffee("10");
    }

    @Then("the inventory will have 25 coffee")
    public void UpdateCoffee(){
        coffee = inventory.getCoffee();
        assertEquals(inventory.getCoffee(),25);
    }

    @When("I add {int} chocolate into inventory")
    public void AddChocolate(int n) throws InventoryException {
       inventory.addChocolate("10");
    }

    @Then("the inventory will have 25 chocolate")
    public void UpdateChocolate(){
        chocolate = inventory.getChocolate();
        assertEquals(chocolate,25);
    }

    @When("I add {int} milk into inventory")
    public void AddMilk(int n) throws InventoryException {
        inventory.addMilk("10");
    }

    @Then("the inventory will have 25 milk")
    public void UpdateMilk(){
        milk = inventory.getMilk();
        assertEquals(milk,25);
    }

    @Given("Start Coffee maker")
    public void StartCoffeeMaker() throws RecipeException {
        coffeeMaker = new CoffeeMaker();
        recipe1 = CreateRecipe("Latte","0","3","3","1","75");
        recipe2 = CreateRecipe("Milktea","7","6","5","2","60");

        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
    }

    @When("Customer pay Latte {int}")
    public void BuyLatte(int n) {

        index = 0;
        money = 75;
    }

    @Then("Customer get Latte and no change")
    public void getLatte(){

        change = coffeeMaker.makeCoffee(index,money);

        assertEquals(change,0);

    }

    @When("Customer pay {int}")
    public void BuyLatteButGetChange(int n) {

        index = 0;
        money = 100;
    }

    @Then("Customer get Milktea and 40 change")
    public void getLatteAndChange(){

        change = coffeeMaker.makeCoffee(0,money);

        assertEquals(change, 25);
    }










}
