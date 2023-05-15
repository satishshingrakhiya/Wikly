import { Component } from '@angular/core';
import { Society } from '../society';
import { SocietyService } from '../society.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-society-list',
  templateUrl: './society-list.component.html',
  styleUrls: ['./society-list.component.css']
})
export class SocietyListComponent {

  constructor(private societyService: SocietyService, private router: Router) {}

  societies: Society[];

  ngOnInit(): void {
    this.getSocieties();
  }

  private getSocieties() {
    this.societyService.getSocietyList().subscribe(data => {
      this.societies = data;
    });
  }

  getCategories(societyId: number) {
    this.router.navigate(['categories', societyId]);
  }

}
