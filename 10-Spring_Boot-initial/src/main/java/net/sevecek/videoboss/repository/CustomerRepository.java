package net.sevecek.videoboss.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import net.sevecek.videoboss.entity.Customer;

@Repository
public class CustomerRepository {

    private List<Customer> data = Arrays.asList(
            new Customer(UUID.fromString("bf10d0a8-6a1b-480a-ac31-1062ce58dbc1"), "Jan Dvořák", "jan.dvorak@gmail.com", "Veselá 16", "111 50", "Praha"),
            new Customer(UUID.randomUUID(), "František Kožich", "fran.kozich@seznam.cz", "Nerudova 5", "111 50", "Ostrava"),
            new Customer(UUID.fromString("219ee681-4654-4716-bcf8-3a82a2cb414b"), "Daniel Válec", "dan@valec.cz", "Jabloňová 8", "602 00", "Brno"),
            new Customer(UUID.fromString("d00d689e-2ab6-41c9-9a85-e5f6ba515878"), "Karel Fendrich", "karel.f@gmail.com", "Plantážní 5", "606 00", "Plzeň"),
            new Customer(UUID.fromString("5ea663e3-94c0-498c-9bf8-d1119febfb77"), "Petr Kozák", "petr.kozak@email.cz", "Vysoká 18", "532 00", "Olomouc"),
            new Customer(UUID.fromString("8ed25054-afd1-4a76-9b57-98e6b387b57a"), "Drahoslav Hartman", "dr.hartman@post.cz", "Jungmannova 33", "110 00", "Praha 1")
    );

    public Iterable<Customer> findAll() {
        return data;
    }

    public Optional<Customer> findById(UUID id) {
        return data.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }
}
