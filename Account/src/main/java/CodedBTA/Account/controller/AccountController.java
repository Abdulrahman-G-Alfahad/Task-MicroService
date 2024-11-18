package CodedBTA.Account.controller;

import CodedBTA.Account.bo.AccountResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.html.HTMLTableCaptionElement;

import javax.swing.text.html.HTML;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final RestTemplate restTemplate;

    private static final String STOCK_API = "http://localhost:8080/api/account";

    public AccountController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/account")
    public ResponseEntity<AccountResponse> getAll(){

        ResponseEntity<AccountResponse> response = restTemplate.getForEntity(STOCK_API, AccountResponse.class);

        return ResponseEntity.ok().body(response.getBody());
    }
}
