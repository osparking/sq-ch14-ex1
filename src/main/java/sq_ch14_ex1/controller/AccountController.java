package sq_ch14_ex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sq_ch14_ex1.model.Account;
import sq_ch14_ex1.model.TransferRequest;
import sq_ch14_ex1.service.TransferService;

@RestController
@AllArgsConstructor
public class AccountController {
	private final TransferService service;
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) {
		service.transferMoney(request);	
	}
	
	@GetMapping("/accounts")
	public Iterable<Account> getAllAccounts(
			@RequestParam(required = false) String name) {
		if (name == null) {
			return service.getAllAccounts();
		} else {
			return service.findByName(name);
		}
		
	}
}
