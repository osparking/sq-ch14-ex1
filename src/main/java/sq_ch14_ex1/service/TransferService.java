package sq_ch14_ex1.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sq_ch14_ex1.repository.AccountRepository;

@Service
@AllArgsConstructor
public class TransferService {
	private final AccountRepository repository;

}
