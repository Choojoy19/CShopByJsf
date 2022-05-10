package sc.task.cshop.controller;

import sc.task.cshop.dao.impl.CoffeeImpl;
import sc.task.cshop.models.Coffee;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean
@SessionScoped
public class CoffeeController {
    private Coffee coffee;
    private List<Coffee> coffees = new ArrayList<Coffee>();
    private CoffeeImpl coffeeService;

    public CoffeeController(){}

    public List<Coffee> getCoffeesList(){
    return coffeeService.findAll();
    }

    public Coffee selectedCoffee (Long id){
        return coffeeService.findById(id);
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public CoffeeImpl getCoffeeService() {
        return coffeeService;
    }

    public void setCoffeeService(CoffeeImpl coffeeService) {
        this.coffeeService = coffeeService;
    }
}
