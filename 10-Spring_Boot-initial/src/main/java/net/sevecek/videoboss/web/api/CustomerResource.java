package net.sevecek.videoboss.web.api;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.repository.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class CustomerResource {

    private CustomerRepository customerRepository;

    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customers/", method = GET)
    @ResponseBody
    public Iterable<Customer> findAll() {
        Iterable<Customer> all = customerRepository.findAll();
        return all;
    }

    @RequestMapping(value = "/customers/{id}", method = GET)
    @ResponseBody
    public Optional<Customer> findById(@PathVariable("id") UUID id) {
        return customerRepository.findById(id);
    }

}
