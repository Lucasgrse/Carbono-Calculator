package br.com.actionlabs.carboncalc.core.voter;

public interface Voter<I> {
    void invoke(I useCaseInput);
}