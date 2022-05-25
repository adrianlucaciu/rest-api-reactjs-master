package com.mightyjava.repository;

import com.mightyjava.domain.Lines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinesRepository extends PagingAndSortingRepository<Lines, Long> {

    @Query("FROM Lines b WHERE b.lineNumber LIKE %:searchText% OR b.firstStation LIKE %:searchText% OR b.language LIKE %:searchText% OR b.genre LIKE %:searchText% ORDER BY b.stations ASC")
    Page<Lines> findAllBooks(Pageable pageable, @Param("searchText") String searchText);
}
