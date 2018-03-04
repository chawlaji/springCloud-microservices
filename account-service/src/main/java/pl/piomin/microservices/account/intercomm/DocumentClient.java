package pl.piomin.microservices.account.intercomm;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.piomin.microservices.account.model.Document;

@Qualifier("docsC")
@FeignClient("documents-service")
public interface DocumentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/documents/account/{accountId}")
	List<Document> getDocuments(@PathVariable("accountId") int accountId);
    
}
