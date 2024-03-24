import { Input, Component } from '@angular/core';

@Component({
  selector: 'app-nav-dashboard-admin2',
  templateUrl: './nav-dashboard-admin2.component.html',
  styleUrls: ['./nav-dashboard-admin2.component.css']
})
export class NavDashboardAdmin2Component {
  @Input() pageTitle: string = '';
}
