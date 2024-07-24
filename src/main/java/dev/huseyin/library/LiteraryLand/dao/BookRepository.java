package dev.huseyin.library.LiteraryLand.dao;

import dev.huseyin.library.LiteraryLand.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
