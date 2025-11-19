import { Routes } from '@angular/router';
import { UsercomumComponent } from './usercomum/usercomum.component';
import { FormUsercomum} from './form-usercomum/form-usercomum';

export const routes: Routes = [
    {path: 'usercomum', component: UsercomumComponent},
    {path: 'usercomum/novo', component: FormUsercomum}
];
