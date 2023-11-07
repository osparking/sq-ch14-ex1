package sq_ch14_ex1.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import sq_ch14_ex1.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	@Query("select * from account where name=:custname")
	List<Account> findAccountsByCustname(String custname);
	
	@Query("update account set amount = :amount where id = :id ")
	@Modifying
	void changeAmount(long id, BigDecimal amount);

	@Query("select * from account where amount > :amountAbove")
	List<Account> findAccountAboveAmount(BigDecimal amountAbove);
}
