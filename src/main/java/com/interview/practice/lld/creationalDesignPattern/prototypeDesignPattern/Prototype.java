package com.interview.practice.lld.creationalDesignPattern.prototypeDesignPattern;

public interface Prototype<T> {
    T clone() throws CloneNotSupportedException;
}
