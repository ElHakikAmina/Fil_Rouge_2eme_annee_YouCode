import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommentService } from 'src/app/Services/Comment/comment.service';
import { Comment } from 'src/app/models/comment';

@Component({
  selector: 'app-showcomments',
  templateUrl: './showcomments.component.html',
  styleUrls: ['./showcomments.component.css']
})
export class ShowcommentsComponent {

  comments:Array<Comment> = []
  constructor (private commentService:CommentService,private route: ActivatedRoute){}

  private id:number = 0

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      // Use the extracted ID (e.g., display it, fetch data)
      console.log('Extracted ID:', id);
      this.id =id
    });
    
    this.getAllComments(this.id)
  }
  getAllComments(idProduct:number) {
    this.commentService.getAllComments(idProduct)
      .subscribe({
        next: data => {
          this.comments = data
          console.log(data)
        },
        error: err => {
          console.error(err);
        }
      });
  }

}
