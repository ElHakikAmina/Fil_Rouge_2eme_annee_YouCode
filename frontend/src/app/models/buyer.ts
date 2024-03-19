import { RoleUser } from './role-user.enum';

export interface Buyer {
    id: number;
    email: string;
    password: string;
    Nom: string;
    Prenom: string;
    roleUser: RoleUser;
    isVerifie: boolean;
}