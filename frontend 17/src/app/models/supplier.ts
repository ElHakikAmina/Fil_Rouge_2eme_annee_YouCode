import { RoleUser } from './role-user.enum';

export interface Supplier {
    id: number;
    email: string;
    image: string;
    Nom: string;
    password: string;
    roleUser: RoleUser;
    isVerifie: boolean;
}
