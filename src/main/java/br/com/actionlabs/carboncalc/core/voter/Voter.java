package br.com.actionlabs.carboncalc.core.voter;

import br.com.actionlabs.carboncalc.infra.exceptions.NotFoundException;

public interface Voter<I> {
    void invoke(I useCaseInput) throws NotFoundException;
}