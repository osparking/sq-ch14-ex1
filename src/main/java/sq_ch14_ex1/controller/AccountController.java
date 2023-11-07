package sq_ch14_ex1.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import space.jbpark.utility.MyUtil;
import sq_ch14_ex1.model.Account;
import sq_ch14_ex1.model.TransferRequest;
import sq_ch14_ex1.service.TransferService;

@RestController
@AllArgsConstructor
public class AccountController {
	private final TransferService service;
	private final Logger logger = MyUtil
			.getLogger(AccountController.class.getName());

	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) {
		service.transferMoney(request);
	}

	@GetMapping("/accounts")
	public Iterable<Account> getAllAccounts(
			@RequestParam(required = false) String custname) {
		logger.info("계좌주:" + custname);
		if (custname == null) {
			return service.getAllAccounts();
		} else {
			return service.findAccountsByCustname(custname);
		}

	}

	@GetMapping("/account")
	public Account getAccountById(
			@RequestParam(required = true) Long id) {
		logger.info("id: " + id);
		return service.findAccountById(id);
	}
	
	@GetMapping("/accountAbove")
	public List<Account> findAccountAboveAmount(
			@RequestParam(required = true) BigDecimal amountAbove) {
		logger.info("다음 초과: " + amountAbove);
		return service.findAccountAboveAmount(amountAbove);
	}

}
