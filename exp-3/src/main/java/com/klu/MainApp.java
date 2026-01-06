package com.klu;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mobile", "Electronics", 25000, 15));
        session.save(new Product("Headphones", "Accessories", 2000, 30));
        session.save(new Product("Keyboard", "Accessories", 1500, 0));
        session.save(new Product("Mouse", "Accessories", 800, 25));
        session.save(new Product("Monitor", "Electronics", 12000, 5));

        tx.commit();

        System.out.println("---- Products by Price ASC ----");
        List<Product> list1 =
                session.createQuery("from Product p order by p.price asc", Product.class).list();
        list1.forEach(p -> System.out.println(p.getName()));

        System.out.println("---- Products by Price DESC ----");
        session.createQuery("from Product p order by p.price desc", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        System.out.println("---- Products by Quantity DESC ----");
        session.createQuery("from Product p order by p.quantity desc", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        System.out.println("---- First 3 Products ----");
        Query<Product> q1 = session.createQuery("from Product", Product.class);
        q1.setFirstResult(0);
        q1.setMaxResults(3);
        q1.list().forEach(p -> System.out.println(p.getName()));

        System.out.println("---- Next 3 Products ----");
        Query<Product> q2 = session.createQuery("from Product", Product.class);
        q2.setFirstResult(3);
        q2.setMaxResults(3);
        q2.list().forEach(p -> System.out.println(p.getName()));

        Long total =
                session.createQuery("select count(p) from Product p", Long.class).uniqueResult();
        System.out.println("Total Products: " + total);

        Long available =
                session.createQuery(
                        "select count(p) from Product p where p.quantity > 0",
                        Long.class).uniqueResult();
        System.out.println("Available Products: " + available);

        session.createQuery(
                "from Product p where p.price between 5000 and 30000",
                Product.class).list().forEach(p -> System.out.println(p.getName()));

        session.createQuery("from Product p where p.name like 'M%'", Product.class)
                .list().forEach(p -> System.out.println(p.getName()));

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
