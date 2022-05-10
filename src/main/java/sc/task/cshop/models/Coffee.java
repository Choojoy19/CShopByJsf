package sc.task.cshop.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.Objects;
@ManagedBean
@RequestScoped
@Entity
@Table(name = "coffee_table")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String item;
    @Column
    private int priceForOnePack;

    public Coffee(String item, int priceForOnePack) {
        this.item = item;
        this.priceForOnePack = priceForOnePack;
    }

    public Coffee() {

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPriceForOnePack() {
        return priceForOnePack;
    }

    public void setPriceForOnePack(int priceForOnePack) {
        this.priceForOnePack = priceForOnePack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", priceForOnePack=" + priceForOnePack +
                '}';
    }
}
