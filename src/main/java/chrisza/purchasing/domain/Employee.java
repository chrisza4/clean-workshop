package chrisza.purchasing.domain;

public class Employee {
    private String EmailAddress;

    public Employee(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public Employee() {

    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.EmailAddress = emailAddress;
    }

    public EmployeeLevel level() {
        switch (this.EmailAddress) {
            case "steve@microapplesoft.com":
                return EmployeeLevel.MidLevelManagement;
            case "mark@microapplesoft.com":
                return EmployeeLevel.SeniorManagement;
            default:
                return EmployeeLevel.Employee;
        }

    }
}
