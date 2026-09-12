package com.art5019.art5019s_injustice.data.common;

import java.util.*;

public class WeightedList<T> {
    private Map<T, Float> entries;
    private float totalWeight;

    public WeightedList(Map<T, Float> entries) {
        this.entries = entries;
        entries.values().forEach(x -> totalWeight += x);
    }

    public WeightedList(T value) {
        entries = Map.of(value, 1.0F);
        totalWeight = 1F;
    }

    public WeightedList(Float commonChance, List<T> values) {
        entries = new HashMap<>();
        values.forEach(x -> entries.put(x, commonChance));
        totalWeight = values.size() * commonChance;
    }

    public T getRandom() {
        Random random = new Random();
        float target = random.nextFloat(0,totalWeight);
        List<T> keys = entries.keySet().stream().toList();
        float sum = 0;
        for (int i = 0; i < keys.size(); i++) {
            sum += entries.get(keys.get(i));
            if(target < sum) {
                return keys.get(i);
            }
        }
        return keys.getFirst();
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void addEntry(T entry, Float weight) {
        entries.put(entry,weight);
    }

    public void addEntry(Map<T, Float> entries) {
        this.entries.putAll(entries);
    }
}
