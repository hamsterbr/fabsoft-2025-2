import { Routes } from '@angular/router';
import { UsercomumComponent } from './usercomum/usercomum.component';
import { FormUsercomum} from './form-usercomum/form-usercomum';
import { UseradmComponent } from './useradm/useradm.component';
import { FormUseradm } from './form-useradm/form-useradm';      

export const routes: Routes = [
    {path: 'usercomum', component: UsercomumComponent},
    {path: 'usercomum/novo', component: FormUsercomum},

    {path: 'useradm', component: UseradmComponent},
    {path: 'useradm/novo', component: FormUseradm}
];
