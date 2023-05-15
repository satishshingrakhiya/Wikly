import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Review } from './review';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private httpClient: HttpClient) { }

  private baseURL = "http://localhost:8086/reviewservice/api/v1/reviews/"

  getReviews(categoryId: number): Observable<Review[]> {
    return this.httpClient.get<Review[]>(`${this.baseURL}/${categoryId}`);
  }
}
