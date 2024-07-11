import { Component } from '@angular/core';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent {

  currentComponent: String = '';

  showComponent(component: String)
  {
    this.currentComponent = component;
  }
}
