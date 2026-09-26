package com.art5019.art5019s_injustice.data.common;

@FunctionalInterface
public interface IdMapper<T> {
    T fromId(int id);
}
