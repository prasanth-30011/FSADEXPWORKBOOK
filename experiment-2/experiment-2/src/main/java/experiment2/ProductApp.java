package experiment2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop", "HP Pavilion", 60000, 5);
        Product p2 = new Product("Mobile", "OnePlus", 35000, 10);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        factory.close();
    }
}
