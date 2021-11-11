package com.example.book.repository;

import com.example.book.entity.Book;
import com.example.book.entity.Place;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>,  JpaSpecificationExecutor<Book>{

    @Query("SELECT e FROM Book e where e.name = :name")
    List<Book> getAllBooksByName(@Param("name") String name);

    List<Book> findBookByCode(String code);

    // criteria API dung de truy van, khi can theo gi thi cu add vao
    // lay gia sach cua sach co id <= 7
    static Specification<Book> iWantThisBookDemo() {
        List<Predicate> predicates = new ArrayList<>();
        return (root, query, criteriaBuilder) -> {
//            predicates.add(criteriaBuilder.like(root.get("name"), "OASKA"));
//            Join<Book, Place> placeJoin = root.join("id", JoinType.INNER);
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("id"), "7"));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
