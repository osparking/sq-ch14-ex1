package sq_ch14_ex1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import sq_ch14_ex1.exception.AccountNotFoundException;
import sq_ch14_ex1.model.TransferRequest;
import sq_ch14_ex1.repository.AccountRepository;

@Service
@AllArgsConstructor
public class TransferService {
	private final AccountRepository repository;

	@Transactional
	public void transferMoney(TransferRequest request) {
		var optSender = repository.findById(request.getSenderId())
				.orElseThrow(() -> new AccountNotFoundException());
		var optReceiver = repository.findById(request.getReceiverId())
				.orElseThrow(() -> new AccountNotFoundException());

		var senderAmt = optSender.getAmount().subtract(request.getAmount());
		var receiverAmt = optReceiver.getAmount();
		receiverAmt.add(request.getAmount());

		repository.changeAmount(request.getSenderId(), senderAmt);
		repository.changeAmount(request.getReceiverId(), receiverAmt);
	}

}
