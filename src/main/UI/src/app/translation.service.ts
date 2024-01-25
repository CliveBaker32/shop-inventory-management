import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse,HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class TranslationService {

  constructor(private http: HttpClient) { }


  getMessage(): Observable<string> {
    const url = 'http://localhost:8080/welcome/getmessage'; // Update with your Spring Boot backend URL
    return this.http.get<string>(url, {responseType: 'text' as 'json'});
  }

  getTimeZone(): Observable<string> {
    const url = 'http://localhost:8080/welcome/timezone'; // Update with your Spring Boot backend URL
    return this.http.get<string>(url, {responseType: 'text' as 'json'});
  }



}
