import { Supplier } from "./supplier";
import { Category } from "./category";
export interface Product {
image: any;
    id: number;
    name: string;
    prix: number;
    less_quantity: number;
    quantity: number;
    description: string;
    supplier: Supplier;
    category: Category;
}

