package sq_ch14_ex1.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransferRequest {
	private Long senderId;
	private Long receiverId;
	private BigDecimal amount;

}
