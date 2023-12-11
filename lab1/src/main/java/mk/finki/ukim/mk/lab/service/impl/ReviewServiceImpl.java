package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.repository.jpa.ReviewRepositoryJpa;
import mk.finki.ukim.mk.lab.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepositoryJpa reviewRepository;

    public ReviewServiceImpl(ReviewRepositoryJpa reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findReviewsByBook(Book book) {
        return reviewRepository.findReviewsByBook(book);
    }
}
