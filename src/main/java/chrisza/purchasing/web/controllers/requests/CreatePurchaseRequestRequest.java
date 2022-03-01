package chrisza.purchasing.web.controllers.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;

public class CreatePurchaseRequestRequest {
    private String ownerEmail;
    private String approverEmail;
    private ArrayList<PurchaseListItemRequest> items;

    public CreatePurchaseRequestRequest() {

    }

    public ArrayList<PurchaseListItemRequest> getItems() {
        return items;
    }

    public void setItems(ArrayList<PurchaseListItemRequest> items) {
        this.items = items;
    }

    public String getApproverEmail() {
        return approverEmail;
    }

    public void setApproverEmail(String approverEmail) {
        this.approverEmail = approverEmail;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public PurchaseRequest toDomainObject() {
        List<PurchaseRequestItem> domainItems = items.stream().map(item -> item.toDomainObject())
                .collect(Collectors.toList());
        return new PurchaseRequest(domainItems, new Employee(ownerEmail), new Employee(approverEmail));
    }
}
