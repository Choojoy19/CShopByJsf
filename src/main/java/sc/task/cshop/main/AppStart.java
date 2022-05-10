package sc.task.cshop.main;

import sc.task.cshop.dao.impl.CoffeeImpl;
import sc.task.cshop.models.Coffee;

import java.util.List;

public class AppStart {
    public static void main(String[] args) {
        CoffeeImpl coffee= new CoffeeImpl();
//        Coffee coffee1 = new Coffee("Arabica",60);
//        Coffee coffee2 = new Coffee("Robusta",50);
//        Coffee coffee3 = new Coffee("Liberica",70);
//        Coffee coffee4 = new Coffee("Excelsa",90);
//        coffee.create(coffee1);
//        coffee.create(coffee2);
//        coffee.create(coffee3);
//        coffee.create(coffee4);

        List<Coffee> coffees = coffee.findAll();
        Coffee coffee1 = coffee.findById(1L);

    }
}
