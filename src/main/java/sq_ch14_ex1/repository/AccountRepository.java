package sq_ch14_ex1.repository;

import org.springframework.data.repository.CrudRepository;

import sq_ch14_ex1.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
