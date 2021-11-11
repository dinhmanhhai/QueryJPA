//package com.example.book.specification;
//
//import com.example.book.entity.Book;
//import org.springframework.data.jpa.domain.Specification;
//import jakarta.persistence.criteria.*;
//
//import javax.persistence.criteria.Predicate;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookSpecification {
////    public static Specification<Book> iWantThisBookDemo() {
////        List<Predicate> predicates = new ArrayList<>();
////        return (root, query, criteriaBuilder) -> {
////            predicates.add(criteriaBuilder.like(root.get("name"), "HN"));
////            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
////        };
////    }
//}
