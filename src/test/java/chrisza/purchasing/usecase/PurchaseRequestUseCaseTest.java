package chrisza.purchasing.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;
import chrisza.purchasing.fixtures.PurchaseRequestFixtures;
import chrisza.purchasing.persistance.PurchaseRequestRepositoryImpl;

public class PurchaseRequestUseCaseTest {
    @Test
    void ShouldThrowForInvalidPurchaseRequest() {
        var pr = PurchaseRequestFixtures.getInvalidPurchaseRequest();
        var useCase = new PurchaseRequestUseCase(new MockRepo());
        assertThrows(InvalidPurchaseRequestException.class, () -> useCase.Create(pr));
    }

    @Test
    void ShouldSaveToRepository() throws InvalidPurchaseRequestException {
        var pr = PurchaseRequestFixtures.getValidPurchaseRequest();
        var mockRepo = new MockRepo();
        var useCase = new PurchaseRequestUseCase(mockRepo);
        useCase.Create(pr);
        assertTrue(mockRepo.IsCreated);
    }

    private class MockRepo extends PurchaseRequestRepositoryImpl {
        public Boolean IsCreated;

        @Override
        public PurchaseRequest Create(PurchaseRequest purchaseRequest) {
            this.IsCreated = true;
            return purchaseRequest;
        }
    }
}
