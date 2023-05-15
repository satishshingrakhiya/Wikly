import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Society } from './society';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SocietyService {

  constructor(private httpClient: HttpClient) { }

  private baseURL = "http://localhost:8081/categoryservice/api/v1/societies"

  getSocietyList(): Observable<Society[]> {
    return this.httpClient.get<Society[]>(`${this.baseURL}`);
  }

}
