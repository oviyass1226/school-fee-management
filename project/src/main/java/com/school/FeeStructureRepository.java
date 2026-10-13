
package com.school;

import java.util.HashMap;
import java.util.Map;

public class FeeStructureRepository {

    private Map<String, FeeStructure> feeStructures = new HashMap<>();

    public void addFeeStructure(FeeStructure feeStructure) {

        if (feeStructure == null) {
            throw new IllegalArgumentException(
                    "Fee structure cannot be null"
            );
        }

        String className = feeStructure.getClassName();

        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Class name cannot be empty"
            );
        }

        if (feeStructures.containsKey(className.toLowerCase())) {
            throw new IllegalArgumentException(
                    "Fee structure already exists for class: " + className
            );
        }

        feeStructures.put(className.toLowerCase(), feeStructure);
    }

    public FeeStructure getFeeStructure(String className) {

        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Class name cannot be empty"
            );
        }

        return feeStructures.get(className.toLowerCase());
    }

    public Map<String, FeeStructure> getAllFeeStructures() {
        return new HashMap<>(feeStructures);
    }
}
