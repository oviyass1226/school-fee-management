package com.school;

import java.util.HashSet;
import java.util.Set;

public class FeeStructure {

    private String className;
    private Set<FeeHead> feeHeads;

    public FeeStructure(String className) {
        this.className = className;
        this.feeHeads = new HashSet<>();
    }

    public void addFeeHead(FeeHead feeHead) {
        feeHeads.add(feeHead);
    }

    public String getClassName() {
        return className;
    }

    public Set<FeeHead> getFeeHeads() {
        return feeHeads;
    }
}