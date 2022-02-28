package chrisza.purchasing.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.persistance.PurchaseRequestRepositoryImpl;
import chrisza.purchasing.usecase.PurchaseRequestUseCase;

@RestController
public class PurchaseRequestController {

    @PostMapping("/pr")
    public ResponseEntity<PurchaseRequest> create(@RequestBody PurchaseRequest model) {
        var useCase = new PurchaseRequestUseCase(new PurchaseRequestRepositoryImpl());
        try {
            return new ResponseEntity<PurchaseRequest>(useCase.Create(model), HttpStatus.ACCEPTED);
        } catch (InvalidPurchaseRequestException e) {
            return new ResponseEntity<PurchaseRequest>(HttpStatus.FORBIDDEN);
        }
    }
}