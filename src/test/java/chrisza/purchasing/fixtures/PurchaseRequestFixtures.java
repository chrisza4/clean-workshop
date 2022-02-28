package chrisza.purchasing.fixtures;

import java.util.ArrayList;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;

public class PurchaseRequestFixtures {
    public static PurchaseRequest getInvalidPurchaseRequest() {
        var item1 = new PurchaseRequestItem("MacBook", 2, 100001);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("steve@microapplesoft.com");

        return new PurchaseRequest(items, owner, approver);
    }

    public static PurchaseRequest getValidPurchaseRequest() {
        var item1 = new PurchaseRequestItem("MacBook", 2, 9999);
        var items = new ArrayList<PurchaseRequestItem>();
        items.add(item1);

        var owner = new Employee("billgates@microsoft.com");
        var approver = new Employee("steve@microapplesoft.com");

        return new PurchaseRequest(items, owner, approver);
    }
}
