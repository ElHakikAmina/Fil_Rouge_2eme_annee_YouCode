import { RoleUser } from './role-user.enum';

export interface Buyer {
    id: number;
    email: string;
    password: string;
    nom: string;
    prenom: string;
    roleUser: RoleUser;
    isVerifie: boolean;
}