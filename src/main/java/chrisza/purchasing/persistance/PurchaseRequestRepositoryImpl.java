package chrisza.purchasing.persistance;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Component;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

@Component
public class PurchaseRequestRepositoryImpl implements PurchaseRequestRepository {

    private ArrayList<PurchaseRequest> purchaseRequests;

    public PurchaseRequestRepositoryImpl() {
        this.purchaseRequests = new ArrayList<PurchaseRequest>();
    }

    @Override
    public PurchaseRequest Create(PurchaseRequest purchaseRequest) {
        purchaseRequest.setId(UUID.randomUUID());
        this.purchaseRequests.add(purchaseRequest);
        return purchaseRequest;
    }

    @Override
    public PurchaseRequest getById(UUID id) {
        for (var purchaseRequest : this.purchaseRequests) {
            if (purchaseRequest.getId().equals(id)) {
                return purchaseRequest;
            }
        }
        return null;
    }

}
