package chrisza.purchasing.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class PurchaseRequestTest {
    @Test
    void ShouldBeValidForPrWhichApproverIsAManager() {
        var item1 = new PurchaseRequestItem("MacBook", 2, 20000);
        var item2 = new PurchaseRequestItem("PS5 Digital Edition", 1, 13990);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);
        items.add(item2);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("mark@microapplesoft.com");

        var createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertTrue(createdPurchaseRequest.isValid());

    }

    @Test
    void ShouldBeInValidForPrWhichApproverIsAnEmployee() {
        var item1 = new PurchaseRequestItem("MacBook", 2, 20000);
        var item2 = new PurchaseRequestItem("PS5 Digital Edition", 1, 13990);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);
        items.add(item2);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("mike@microapplesoft.com");

        var createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertFalse(createdPurchaseRequest.isValid());

    }

    @Test
    void ShouldBeInValidForPrWhichApproverIsAMidManagerExceed100000THB() {
        var item1 = new PurchaseRequestItem("MacBook", 2, 100001);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("steve@microapplesoft.com");

        var createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertFalse(createdPurchaseRequest.isValid());
    }

    @Test
    void ShouldBeInValidForPrWhichApproverIsASeniorManagerExceed100000THB() {
        var item1 = new PurchaseRequestItem("MacBook", 2, 100001);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("mark@microapplesoft.com");

        var createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertTrue(createdPurchaseRequest.isValid());
    }

}
