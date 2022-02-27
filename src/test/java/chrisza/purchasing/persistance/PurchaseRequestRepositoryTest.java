package chrisza.purchasing.persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;

public class PurchaseRequestRepositoryTest {
    @Test
    void CanCreatePurchaseRequest() {
        var repo = new PurchaseRequestRepositoryImpl();
        var item1 = new PurchaseRequestItem("MacBook", 2, 100000);
        var item2 = new PurchaseRequestItem("PS5 Digital Edition", 1, 13990);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);
        items.add(item2);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("jeffbesoz@amazon.com");

        var purchaseRequest = new PurchaseRequest(items, owner, approver);

        var createdRequestId = repo.Create(purchaseRequest).getId();
        var createdPurchaseRequest = repo.getById(createdRequestId);
        assertEquals("billgates@microsoft.com", createdPurchaseRequest.getOwner().getEmailAddress());
        assertEquals("jeffbesoz@amazon.com", createdPurchaseRequest.getApprover().getEmailAddress());
        assertEquals(2, createdPurchaseRequest.getItems().size());

        var macbook = createdPurchaseRequest.getItems().get(0);
        assertEquals("MacBook", macbook.getItem());
        assertEquals(2, macbook.getAmount());
        assertEquals(100000, macbook.getTotalPrice());

        var ps5 = createdPurchaseRequest.getItems().get(1);
        assertEquals("PS5 Digital Edition", ps5.getItem());
        assertEquals(1, ps5.getAmount());
        assertEquals(13990, ps5.getTotalPrice());

    }
}
