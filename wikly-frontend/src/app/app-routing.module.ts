import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SocietyListComponent } from './society-list/society-list.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { ReviewComponent } from './review/review.component';

const routes: Routes = [
  {path: 'societies', component: SocietyListComponent},
  {path: '', redirectTo: 'societies', pathMatch: 'full'},
  {path: 'categories/:societyId', component: CategoryListComponent},
  {path: 'reviews/:categoryId', component: ReviewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
