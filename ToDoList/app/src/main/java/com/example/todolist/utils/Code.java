package com.example.todolist.utils;

public enum Code {
    addItemRequestCode(0), addItemResponseCode(1);

    private final int value;
    private Code(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}