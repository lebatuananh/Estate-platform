package com.mra.repository.paging;

public interface Pageable {
    Integer getOffset();
    Integer getPageSize();
    Integer getPageNumber();
}
