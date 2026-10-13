
package com.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeeStructureRepositoryTest {

    @Test
    void shouldAddAndRetrieveFeeStructure() {
        FeeStructureRepository repository =
                new FeeStructureRepository();

        FeeStructure structure = new FeeStructure("10-A");

        repository.addFeeStructure(structure);

        assertEquals(
                structure,
                repository.getFeeStructure("10-A")
        );
    }

    @Test
    void shouldRejectDuplicateClass() {
        FeeStructureRepository repository =
                new FeeStructureRepository();

        repository.addFeeStructure(
                new FeeStructure("10-A")
        );

        assertThrows(IllegalArgumentException.class, () -> {
            repository.addFeeStructure(
                    new FeeStructure("10-A")
            );
        });
    }

    @Test
    void shouldRetrieveClassIgnoringCase() {
        FeeStructureRepository repository =
                new FeeStructureRepository();

        FeeStructure structure = new FeeStructure("10-A");
        repository.addFeeStructure(structure);

        assertEquals(
                structure,
                repository.getFeeStructure("10-a")
        );
    }

    @Test
    void shouldRejectNullFeeStructure() {
        FeeStructureRepository repository =
                new FeeStructureRepository();

        assertThrows(IllegalArgumentException.class, () -> {
            repository.addFeeStructure(null);
        });
    }
}
