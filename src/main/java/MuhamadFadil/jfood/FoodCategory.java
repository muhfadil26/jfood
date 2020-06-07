package MuhamadFadil.jfood;
/**
 * Write a description of class FoodCategory here.
 * this enum is used for Foodcategory
 * @author Muhamad Fadil
 * @version 5 Maret 2020
 */

public enum FoodCategory
{
    //kategori yang ada pada Food
    Beverage("Beverage"), Coffe("Coffe"), Western("Westren"), Snacks("Snacks"), Rice("Rice"), Noodles("Noodles"), Bakery("Bakery"), Japanese("Japanese");

    //variable category
    private String category;

    //konstraktor yang digunakan untuk memastikan category
    private FoodCategory(String category){
        this.category=category; 
    }

    //metode untuk cetak class FoodCategory
    public String toString (){
        return category; 
    }
}


   
