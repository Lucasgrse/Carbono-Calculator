package br.com.actionlabs.carboncalc.core.usecase;

public interface UseCase<I, O> {
    O execute(I input);
}