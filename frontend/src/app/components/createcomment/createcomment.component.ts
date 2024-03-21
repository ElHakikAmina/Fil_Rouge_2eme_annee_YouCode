import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CommentService } from 'src/app/Services/Comment/comment.service';


@Component({
  selector: 'app-createcomment',
  templateUrl: './createcomment.component.html',
  styleUrls: ['./createcomment.component.css']
})
export class CreatecommentComponent implements OnInit{
  
  constructor(private fb: FormBuilder, private commentService: CommentService,private route: ActivatedRoute) { }

  private id:number = 0

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      // Use the extracted ID (e.g., display it, fetch data)
      console.log('Extracted ID:', id);
      this.id =id
    });
  }

  comment = {
    comment:'',
    product:{
      id:0
    },
    buyer:{
      id:1
    }
  }
  saveComment(comment: any) {
    comment.product.id = Number(this.id)
    
    this.commentService.createComment(comment).subscribe(
      response => {
        console.log('Product created successfully:', response);
        // Handle success, e.g., show a success message
      },
      error => {
        console.error('Error creating product:', error);
        // Handle error, e.g., show an error message
      }
    );
  }
  

}

