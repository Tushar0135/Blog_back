package com.example.Blog_back.repository;

import com.example.Blog_back.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogsRepository extends JpaRepository<Blogs, Long> {
    Optional<Blogs> findByName(String name);

    List<Blogs> findAllByCategory(String category);

}
