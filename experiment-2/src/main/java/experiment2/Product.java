package experiment2;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(){}

    public Product(String name,String description,double price,int quantity){
        this.name=name;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
    }

    public void setPrice(double price){ this.price=price; }
    public void setQuantity(int quantity){ this.quantity=quantity; }

    @Override
    public String toString(){
        return "Product [id="+id+", name="+name+", price="+price+", quantity="+quantity+"]";
    }
}
