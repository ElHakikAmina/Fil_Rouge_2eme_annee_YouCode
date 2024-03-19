import { Buyer } from "./buyer";
import { Product } from "./product";

export interface AchatProduct {
    id: number;
    quantity: number;
    product: Product;
    buyer: Buyer;
}
