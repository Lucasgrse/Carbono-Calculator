package br.com.actionlabs.carboncalc.core;

public interface UseCase<I, O> {
    O execute(I input);
}