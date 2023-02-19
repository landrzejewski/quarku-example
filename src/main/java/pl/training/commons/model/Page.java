package pl.training.commons.model;

public record Page(int number, int size) {

    public int getOffset() {
        return number * size;
    }

}
