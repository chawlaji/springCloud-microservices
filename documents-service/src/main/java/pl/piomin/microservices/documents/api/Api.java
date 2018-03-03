package pl.piomin.microservices.documents.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.documents.model.Document;

@RestController
public class Api {

	private List<Document> documents;

	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	public Api() {
		documents = new ArrayList<>();
	
		documents.add(new Document(1,1,"passport"));
		documents.add(new Document(1,2,"aadharCard"));
		documents.add(new Document(1,3,"DL"));
		documents.add(new Document(1,4,"passport"));
		documents.add(new Document(1,5,"voterID"));
		documents.add(new Document(1,6,"passport"));
		documents.add(new Document(1,7,"aadharCard"));
		documents.add(new Document(1,1,"passport"));
		documents.add(new Document(1,2,"voterID"));
		documents.add(new Document(1,3,"passport"));
		documents.add(new Document(1,4,"DL"));

	}
	
	@RequestMapping("/documents/{id}")
	public Document findByNumber(@PathVariable("id") int id) {
		logger.info(String.format("Account.findById(%s)", id));
		return documents.stream().filter(it -> it.getDocumentId() ==id).findFirst().get();
	}
	
	@RequestMapping("/documents/account/{accountId}")
	public List<Document> findByAccount(@PathVariable("accountId") Integer accountId) {
		logger.info(String.format("Documents.findByAccount(%s)", accountId));
		return documents.stream().filter(it -> it.getAccountId()==accountId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping("/documents")
	public List<Document> findAll() {
		logger.info("Account.findAll()");
		return documents;
	}
	
}
