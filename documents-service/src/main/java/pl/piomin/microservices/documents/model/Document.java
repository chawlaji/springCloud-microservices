package pl.piomin.microservices.documents.model;

public class Document {

	private int documentId;
	private int accountId;
	private String documentName;
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Document(int documentId, int accountId, String documentName) {
		super();
		this.documentId = documentId;
		this.accountId = accountId;
		this.documentName = documentName;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

}