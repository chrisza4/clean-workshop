package chrisza.purchasing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
    @Test
    void MarkShouldBeSeniorManagement() {
        var mark = new Employee("mark@microapplesoft.com");
        assertEquals(EmployeeLevel.SeniorManagement, mark.level());
    }

    @Test
    void SteveShouldBeMidLevel() {
        var steve = new Employee("steve@microapplesoft.com");
        assertEquals(EmployeeLevel.MidLevelManagement, steve.level());
    }

    @Test
    void ShouldReturnEmployeeOtherwise() {
        var john = new Employee("john@microapplesoft.com");
        assertEquals(EmployeeLevel.Employee, john.level());
    }
}
