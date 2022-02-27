package chrisza.purchasing.domain;

import java.util.UUID;

public class PurchaseRequestItem {
    private UUID Id;

    public PurchaseRequestItem(String item, int amount, int totalPrice) {
        Item = item;
        Amount = amount;
        TotalPrice = totalPrice;
    }

    private String Item;
    private int Amount;
    private int TotalPrice;

    public UUID getId() {
        return Id;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.TotalPrice = totalPrice;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        this.Item = item;
    }

    public void setId(UUID id) {
        this.Id = id;
    }
}
