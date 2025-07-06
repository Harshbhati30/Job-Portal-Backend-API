package com.harsh.spring_boot_rest;

import com.harsh.spring_boot_rest.model.JobPost;
import com.harsh.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAlljobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updatePost(@RequestBody JobPost jobpost){
        service.updatePost(jobpost);
        return service.getJob(jobpost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deletePost(@PathVariable int postId){
        service.deletePost(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/Keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }


    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }
}

