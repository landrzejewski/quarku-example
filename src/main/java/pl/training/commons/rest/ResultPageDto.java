package pl.training.commons.rest;

import java.util.List;

public record ResultPageDto<E>(List<E> elements, int pageNumber, int totalPages) {
}
