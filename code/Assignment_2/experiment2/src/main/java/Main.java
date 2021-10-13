import entity.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "bank";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Person person = new Person();
        person.setName("Max Mustermann");

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        CreditCard creditCard1 = new CreditCard();
        creditCard1.setNumber(12345);
        creditCard1.setBalance(-5000);
        creditCard1.setLimit(-10000);

        CreditCard creditCard2 = new CreditCard();
        creditCard2.setNumber(12345);
        creditCard2.setBalance(-5000);
        creditCard2.setLimit(-10000);

        Bank bank = new Bank();
        bank.setName("Pengebank");

        em.persist(person);
        em.persist(address);
        em.persist(creditCard1);
        em.persist(creditCard2);
        em.persist(bank);

        em.getTransaction().commit();
        em.close();
    }
}
