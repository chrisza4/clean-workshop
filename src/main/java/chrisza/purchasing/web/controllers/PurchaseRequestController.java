package chrisza.purchasing.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.usecase.PurchaseRequestUseCase;
import chrisza.purchasing.web.controllers.requests.CreatePurchaseRequestRequest;

@RestController
public class PurchaseRequestController {
    @Autowired
    private PurchaseRequestUseCase purchaseRequestUseCase;

    @PostMapping("/pr")
    public ResponseEntity<PurchaseRequest> create(@RequestBody CreatePurchaseRequestRequest model) {
        var pr = model.toDomainObject();
        try {
            return new ResponseEntity<PurchaseRequest>(purchaseRequestUseCase.Create(pr), HttpStatus.ACCEPTED);
        } catch (InvalidPurchaseRequestException e) {
            return new ResponseEntity<PurchaseRequest>(HttpStatus.FORBIDDEN);
        }
    }
}