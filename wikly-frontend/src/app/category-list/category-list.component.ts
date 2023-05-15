import { Component } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent {

  categories: Category[];

  societyId: number;

  constructor (private categoryService: CategoryService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.societyId = this.route.snapshot.params['societyId'];
    this.categoryService.getCategoryList(this.societyId).subscribe(data => {
      this.categories = data;
    });
  }

  getReviews(categoryId: number){
      this.router.navigate(['reviews', categoryId]);
  }

}
