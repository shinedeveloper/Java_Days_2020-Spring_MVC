package net.sevecek.videoboss.web.api;

import java.util.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import net.sevecek.util.spring.contextdump.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.repository.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class CustomerResource {

    private CustomerRepository customerRepository;
    private ApplicationContext applicationContext;

    public CustomerResource(CustomerRepository customerRepository, ApplicationContext applicationContext) {
        this.customerRepository = customerRepository;
        this.applicationContext = applicationContext;
    }

    @RequestMapping(value = "/customers/", method = GET)
    @ResponseBody
    public Iterable<Customer> findAll() {
        dumpAllBeans();
        Iterable<Customer> all = customerRepository.findAll();
        return all;
    }

    @RequestMapping(value = "/customers/{id}", method = GET)
    @ResponseBody
    public Optional<Customer> findById(@PathVariable("id") UUID id) {
        return customerRepository.findById(id);
    }

    private void dumpAllBeans() {
        Dumper dumper = applicationContext.getBean(Dumper.class);
        dumper.dumpBeans(System.out);
    }
}
