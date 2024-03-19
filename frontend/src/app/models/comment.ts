import { Product } from "./product";
import { Buyer } from "./buyer";
export interface Comment {
    id: number;
    comment: string;
    product: Product;
    buyer: Buyer;
}
