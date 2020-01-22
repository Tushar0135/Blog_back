package com.example.Blog_back.controller;

import com.example.Blog_back.model.Blogs;
import com.example.Blog_back.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blog")
public class BlogController{
    private BlogService blogsService;

    @Autowired
    public BlogController(BlogService blogsService) {
        this.blogsService = blogsService;
    }


//    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @PostMapping(path = "/add")
    public String addNewBlog(@RequestBody Blogs blogs) {
        blogsService.addBlog(blogs);
        return "Service hit!!";
    }

    @GetMapping(path = "/get")
    @ResponseBody
    public Blogs getBlogById(@RequestParam("id") Long id) {
        return blogsService.getById(id);
    }
    @GetMapping(path ="/homeblogs")
    public List<Blogs> getHomeBlogs(){
        return blogsService.findAll();
    }
    @GetMapping(path = "/get-blogs/{category}", produces = "application/json")
    @ResponseBody
    public List<Blogs> getBlogsByCategory(@PathVariable(value = "category") String category){
            return blogsService.getByCategory(category);
    }
    @PostMapping("/add-blog")
    public Boolean addBlog(@RequestBody Blogs blogs) {
        return blogsService.addBlog(blogs);
    }

    @DeleteMapping("/remove-blog")
    public List<Blogs> removeBlog(@RequestParam("id") Long id) {
        return blogsService.deleteItem(id);
    }

    @PutMapping("/edit-blog")
    public Blogs editBlog(@RequestBody Blogs blogs, @RequestParam("id") Long id) {
        return blogsService.editBlog(blogs, id);
    }

    @GetMapping("/get-blogs")
    public List<Blogs> getBlogs() {
        return blogsService.getBlogs();
    }
    @GetMapping(path = "/search")
    public Set<Blogs> getSearch(@RequestParam(value = "value") String value){
        return blogsService.getSearchedBlogs(value);
    }
}
