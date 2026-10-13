
package com.school;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FeeStructureTest {

    @Test
    void shouldCreateFeeStructureSuccessfully() {
        FeeStructure structure = new FeeStructure(" 10-A ");

        assertEquals("10-A", structure.getClassName());
    }

    @Test
    void shouldRejectNullClassName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FeeStructure(null);
        });
    }

    @Test
    void shouldRejectEmptyClassName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FeeStructure("   ");
        });
    }

    @Test
    void shouldAddFeeHeadSuccessfully() {
        FeeStructure structure = new FeeStructure("10-A");
        FeeHead fee = new FeeHead(
                "Tuition", new BigDecimal("20000")
        );

        structure.addFeeHead(fee);

        assertEquals(1, structure.getFeeHeads().size());
    }

    @Test
    void shouldRejectNullFeeHead() {
        FeeStructure structure = new FeeStructure("10-A");

        assertThrows(IllegalArgumentException.class, () -> {
            structure.addFeeHead(null);
        });
    }

    @Test
    void shouldNotAllowExternalChangesToFeeHeads() {
        FeeStructure structure = new FeeStructure("10-A");
        structure.addFeeHead(
                new FeeHead("Tuition", new BigDecimal("20000"))
        );

        Set<FeeHead> feeHeads = structure.getFeeHeads();
        feeHeads.clear();

        assertEquals(1, structure.getFeeHeads().size());
    }
}
