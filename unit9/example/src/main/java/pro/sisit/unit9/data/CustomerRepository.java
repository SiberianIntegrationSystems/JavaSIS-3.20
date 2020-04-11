package pro.sisit.unit9.data;

import org.springframework.data.repository.CrudRepository;
import pro.sisit.unit9.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
