package CodedBTA.Account.controller;

import CodedBTA.Account.bo.AccountResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final RestTemplate restTemplate;
    private static final String STOCK_API = "http://localhost:8080/api/account";

    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/account")
    @CircuitBreaker(name = "accountMS", fallbackMethod = "fallbackMethod")
    public ResponseEntity<AccountResponse> getAll() {
        ResponseEntity<AccountResponse> response = restTemplate.getForEntity(STOCK_API, AccountResponse.class);
        return ResponseEntity.ok().body(response.getBody());
    }

    public ResponseEntity<AccountResponse> fallbackMethod(Throwable throwable) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus("Called Fallback Method");
        System.out.println("Fallback triggered: " + throwable.getMessage());
        return ResponseEntity.ok(accountResponse);
    }
}
