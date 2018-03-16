package pl.piomin.microservices.account.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.account.intercomm.DocumentClient;
import pl.piomin.microservices.account.model.Account;
import pl.piomin.microservices.account.model.Document;

@RestController
public class Api {

	@Autowired
    private DocumentClient documentClient;
	
	private List<Account> accounts;

	protected Logger logger = Logger.getLogger(Api.class.getName());

	public Api() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111"));
		accounts.add(new Account(2, 2, "222222"));
		accounts.add(new Account(3, 3, "333333"));
		accounts.add(new Account(4, 4, "444444"));
		accounts.add(new Account(5, 1, "555555"));
		accounts.add(new Account(6, 2, "666666"));
		accounts.add(new Account(7, 2, "777777"));
	}

	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		Account tempA= accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
		List<Document> documents = documentClient.getDocuments(tempA.getId());
		tempA.setDocuments(documents);
		return tempA
;	}

	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		List<Account> accountsF = accounts.stream().filter(it -> it.getCustomerId().intValue() == customerId.intValue())
				.collect(Collectors.toList());
		accountsF.stream().forEach(item -> {
		int id= item.getId().intValue();
		List<Document> documents = documentClient.getDocuments(id);
		item.setDocuments(documents);
		});
		return accountsF;

	}

	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		
		List<Document> documents = documentClient.getDocuments();
		for (Account cus : accounts) {
			List<Document> account_documents = documents.stream().filter(acc -> acc.getAccountId().equals(cus.getId()))
					.collect(Collectors.toList());
			cus.setDocuments(account_documents);
		}
		return accounts;
	}

}
