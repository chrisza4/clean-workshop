package chrisza.purchasing.domain;

import java.util.List;
import java.util.UUID;

public class PurchaseRequest {
    public UUID id;
    public List<PurchaseRequestItem> Items;
    public Employee Owner;
    public Employee Approver;

    private PurchaseRequest(List<PurchaseRequestItem> items, Employee owner, Employee approver) {
        this.Items = items;
        this.Owner = owner;
        this.Approver = approver;
    }
}
