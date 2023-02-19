package pl.training.commons.model;

import java.util.List;

public record ResultPage<E>(List<E> elements, int pageNumber, int totalPages) {
}
