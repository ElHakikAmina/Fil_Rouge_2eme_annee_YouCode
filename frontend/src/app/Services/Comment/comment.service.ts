import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from 'src/app/models/comment'; // Assuming the path to the Comment interface is correct

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private baseUrl = 'http://localhost:8080/api/Comment'; // Assuming this is the correct base URL

  constructor(private http: HttpClient) { }

  getAllComments(idProduct:number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.baseUrl}/getAllComments/${idProduct}`);
  }

  getComment(id: number): Observable<Comment> {
    return this.http.get<Comment>(`${this.baseUrl}/getComment/${id}`);
  }

  createComment(comment: Comment): Observable<any> {
    return this.http.post(`${this.baseUrl}/createComment`, comment);
  }

  updateComment(comment: Comment): Observable<any> {
    return this.http.put(`${this.baseUrl}/updateComment`, comment);
  }

  deleteComment(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.baseUrl}/deleteComment/${id}`);
  }
}
