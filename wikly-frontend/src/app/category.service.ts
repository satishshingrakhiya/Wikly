import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from './category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) { }

  private baseURL = "http://localhost:8086/categoryservice/api/v1/categories"

  getCategoryList(societyId: number): Observable<Category[]> {
    return this.httpClient.get<Category[]>(`${this.baseURL}/${societyId}`);
  }
}
