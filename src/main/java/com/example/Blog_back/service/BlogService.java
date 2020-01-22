package com.example.Blog_back.service;

import com.example.Blog_back.model.Blogs;
import com.example.Blog_back.repository.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BlogService {
    private BlogsRepository blogsRepository;

    @Autowired
    public BlogService(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    public Boolean addBlog(Blogs items) {
        if (blogsRepository.findByName(items.getName()).isPresent()) {
            return false;
        }
        items.setActive(1);
        blogsRepository.saveAndFlush(items);
        return true;
    }

    public Set<Blogs> getSearchedBlogs(String value) {
        ArrayList<Blogs> items = (ArrayList<Blogs>) blogsRepository.findAll();
        Set<Blogs> result = new HashSet<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().toLowerCase().contains(value.toLowerCase()) ||
                    items.get(i).getCategory().contains(value.toLowerCase()) ||
                    items.get(i).getDetails().toLowerCase().contains(value.toLowerCase())) {
                result.add(items.get(i));
            }
        }
        System.out.println("SearchResult " + result);
        return result;
    }

    public List<Blogs> getBlogs() {
        return blogsRepository.findAll();
    }

    public List<Blogs> getByCategory(String category) {
        return blogsRepository.findAllByCategory(category);
    }

    public Blogs getById(Long id) {
        if (blogsRepository.findById(id).isPresent()) {
            return blogsRepository.findById(id).get();
        }
        return null;
    }

    public List<Blogs> deleteItem(Long id) {
        blogsRepository.deleteById(id);
        return blogsRepository.findAll();
    }

    public List<Blogs> findAll() {
        return blogsRepository.findAll();
    }

    public Blogs editBlog(Blogs newBlog, Long id) {
        Blogs oldBlog = blogsRepository.findById(id).get();
        newBlog.setBlogId(oldBlog.getBlogId());
        newBlog.setActive(oldBlog.getActive());
        blogsRepository.saveAndFlush(newBlog);
        return newBlog;
    }
}
