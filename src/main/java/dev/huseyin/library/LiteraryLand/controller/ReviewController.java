package dev.huseyin.library.LiteraryLand.controller;

import dev.huseyin.library.LiteraryLand.requestModels.ReviewRequest;
import dev.huseyin.library.LiteraryLand.service.ReviewService;
import dev.huseyin.library.LiteraryLand.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value = "Authorization") String token,
                                    @RequestParam Long bookId) throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");

        if (userEmail == null){
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewList(userEmail, bookId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
        if(userEmail == null){throw new Exception("User email missing");}
        reviewService.postReview(userEmail, reviewRequest);
    }

}
