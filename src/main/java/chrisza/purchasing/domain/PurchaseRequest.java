package chrisza.purchasing.domain;

import java.util.List;
import java.util.UUID;

public class PurchaseRequest {
    private UUID id;
    private List<PurchaseRequestItem> Items;
    private Employee Owner;
    private Employee Approver;

    public PurchaseRequest() {

    }

    public PurchaseRequest(List<PurchaseRequestItem> items, Employee owner, Employee approver) {
        this.setItems(items);
        this.setOwner(owner);
        this.setApprover(approver);
    }

    public Employee getApprover() {
        return Approver;
    }

    public void setApprover(Employee approver) {
        this.Approver = approver;
    }

    public Employee getOwner() {
        return Owner;
    }

    public void setOwner(Employee owner) {
        this.Owner = owner;
    }

    public List<PurchaseRequestItem> getItems() {
        return Items;
    }

    public void setItems(List<PurchaseRequestItem> items) {
        this.Items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean isValid() {
        if (Approver.level() == EmployeeLevel.Employee) {
            return false;
        }
        var totalPrice = 0;
        for (var item : this.Items) {
            totalPrice += item.getTotalPrice();
        }
        if (totalPrice > 100000 && Approver.level() == EmployeeLevel.MidLevelManagement) {
            return false;
        }
        return true;
    }
}
