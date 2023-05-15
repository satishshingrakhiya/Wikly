import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReviewService } from '../review.service';
import { Review } from '../review';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent {

  rating: number;

  categoryId: number;

  reviews: Review[];

  constructor (private reviewService: ReviewService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.params['categoryId'];
    this.getReviews(this.categoryId);
  }

  getReviews(categoryId: number) {
      this.reviewService.getReviews(categoryId).subscribe(data => {
        this.reviews = data;
        let sum = 0;
        for (let i=0; i < this.reviews.length; i++ ) {
          sum = sum + this.reviews[i].rating;
        }
        this.rating = sum / this.reviews.length;
      });
  }

}
