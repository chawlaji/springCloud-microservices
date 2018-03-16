package pl.piomin.microservices.documents.model;

public class Document {

	private Integer documentId;
	private Integer accountId;
	private String  documentName;

	public Document() {

	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Document(Integer documentId, Integer accountId, String documentName) {
		super();
		this.documentId = documentId;
		this.accountId = accountId;
		this.documentName = documentName;
	}

	
	

}
