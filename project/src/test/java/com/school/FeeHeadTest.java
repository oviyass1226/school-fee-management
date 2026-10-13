
package com.school;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FeeHeadTest {

    @Test
    void shouldCreateFeeHeadSuccessfully() {
        FeeHead fee = new FeeHead(
                "Tuition",
                new BigDecimal("20000")
        );

        assertEquals("Tuition", fee.getName());
        assertEquals(
                0,
                new BigDecimal("20000").compareTo(fee.getAmount())
        );
    }

    @Test
    void shouldRejectEmptyFeeName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FeeHead("", new BigDecimal("1000"));
        });
    }

    @Test
    void shouldRejectZeroFeeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FeeHead("Tuition", BigDecimal.ZERO);
        });
    }

    @Test
    void shouldRejectNegativeFeeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FeeHead("Tuition", new BigDecimal("-100"));
        });
    }
}
