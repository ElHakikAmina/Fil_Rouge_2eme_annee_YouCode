import { Buyer } from "./buyer";
import { Product } from "./product";

export interface Panier {
    id: number;
    quantity: number;
    product: Product;
    buyer: Buyer;
}
