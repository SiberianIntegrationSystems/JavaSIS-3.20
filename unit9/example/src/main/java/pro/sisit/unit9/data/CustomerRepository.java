package pro.sisit.unit9.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.sisit.unit9.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>,
        JpaRepository<Customer, Long> {
}
