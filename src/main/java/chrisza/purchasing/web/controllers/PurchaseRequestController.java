package chrisza.purchasing.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.persistance.PurchaseRequestRepositoryImpl;
import chrisza.purchasing.usecase.PurchaseRequestUseCase;
import chrisza.purchasing.web.controllers.requests.CreatePurchaseRequestRequest;

@RestController
public class PurchaseRequestController {

    @PostMapping("/pr")
    public ResponseEntity<PurchaseRequest> create(@RequestBody CreatePurchaseRequestRequest model) {
        var useCase = new PurchaseRequestUseCase(new PurchaseRequestRepositoryImpl());
        var pr = model.toDomainObject();
        try {
            return new ResponseEntity<PurchaseRequest>(useCase.Create(pr), HttpStatus.ACCEPTED);
        } catch (InvalidPurchaseRequestException e) {
            return new ResponseEntity<PurchaseRequest>(HttpStatus.FORBIDDEN);
        }
    }
}