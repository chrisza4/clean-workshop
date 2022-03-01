package chrisza.purchasing.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

@Component
public class PurchaseRequestUseCase {

    private PurchaseRequestRepository repo;

    public PurchaseRequestUseCase(@Autowired PurchaseRequestRepository repo) {
        this.repo = repo;
    }

    public PurchaseRequest Create(PurchaseRequest pr) throws InvalidPurchaseRequestException {
        if (!pr.isValid()) {
            throw new InvalidPurchaseRequestException();
        }
        this.repo.Create(pr);
        return pr;
    }

}
