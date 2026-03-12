package experiment2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductApp {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop","Gaming Laptop",90000,5);
        Product p2 = new Product("Mouse","Wireless Mouse",1000,50);

        session.save(p1);
        session.save(p2);

        Product p = session.get(Product.class,1L);
        System.out.println("Product loaded: "+p);

        if(p!=null){
            p.setPrice(85000);
            p.setQuantity(3);
        }

        Product deleteProduct = session.get(Product.class,2L);
        if(deleteProduct!=null)
            session.delete(deleteProduct);

        tx.commit();

        session.close();
        factory.close();
    }
}
