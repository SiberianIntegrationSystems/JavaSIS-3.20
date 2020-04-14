package pro.sisit.unit9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.unit9.data.CustomerRepository;
import pro.sisit.unit9.entity.Customer;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(String name, String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customerRepository.save(customer);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Не существует покупателя под номером " + id));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
