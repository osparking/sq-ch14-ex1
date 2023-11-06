package sq_ch14_ex1.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Account {
	@Id
	private long id;
	private String name;
	private BigDecimal amount;
}
