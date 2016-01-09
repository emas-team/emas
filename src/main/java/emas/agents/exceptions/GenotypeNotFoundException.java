package emas.agents.exceptions;

public class GenotypeNotFoundException extends RuntimeException {
    public GenotypeNotFoundException(Exception e) {
        super(e);
    }

    public GenotypeNotFoundException() {
        super();
    }
}
