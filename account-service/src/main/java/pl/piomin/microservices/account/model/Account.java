package pl.piomin.microservices.account.model;

import java.util.List;

public class Account {

	private Integer id;
	private Integer customerId;
	private String number;
	private List<Document> documents;
	

	public Account() {

	}

	public Account(Integer id, Integer customerId, String number) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.number = number;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
