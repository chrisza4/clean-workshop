package chrisza.purchasing.domain;

public class Employee {
    private String EmailAddress;

    public Employee(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.EmailAddress = emailAddress;
    }
}
