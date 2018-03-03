package pl.piomin.microservices.documents.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class DocumentNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DocumentNotFoundException(int accountId) {
		super("No documents found for account: " + accountId);
	}
	
}
