package sc.task.cshop.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "order_table")
@ManagedBean
@SessionScoped
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;
    @Column
    private int weight;
    @Column
    private Date orderDate;
    @Column
    private LocalTime fromTime;
    @Column
    private LocalTime toTime;
    @Column
    private boolean courierDelivery;
    @Column
    private int cost;

    public Order() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public boolean isCourierDelivery() {
        return courierDelivery;
    }

    public void setCourierDelivery(boolean courierDelivery) {
        this.courierDelivery = courierDelivery;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", coffee=" + coffee +
                ", orderDate=" + orderDate +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                ", courierDelivery=" + courierDelivery +
                ", cost=" + cost +
                '}';
    }
}
