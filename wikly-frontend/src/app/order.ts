import { Item } from "./item";

export class Order {
    orderId: number;
    userId: number;
    orderStatus: string;
    orderedOn: Date;
    deliveredOn: Date;
    items: Item[];
}
