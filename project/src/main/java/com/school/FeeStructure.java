
package com.school;

import java.util.HashSet;
import java.util.Set;

public class FeeStructure {

    private String className;
    private Set<FeeHead> feeHeads;

    public FeeStructure(String className) {

        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Class name cannot be empty"
            );
        }

        this.className = className.trim();
        this.feeHeads = new HashSet<>();
    }

    public void addFeeHead(FeeHead feeHead) {

        if (feeHead == null) {
            throw new IllegalArgumentException(
                    "Fee head cannot be null"
            );
        }

        feeHeads.add(feeHead);
    }

    public String getClassName() {
        return className;
    }

    public Set<FeeHead> getFeeHeads() {
        return new HashSet<>(feeHeads);
    }
}
