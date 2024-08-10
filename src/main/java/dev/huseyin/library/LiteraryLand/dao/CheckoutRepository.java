package dev.huseyin.library.LiteraryLand.dao;

import dev.huseyin.library.LiteraryLand.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
    List<Checkout> findBookByUserEmail(String userEmail);
}
