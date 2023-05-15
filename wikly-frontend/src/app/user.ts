import { Address } from "./address";

export class User {
    userId: number;
    phoneNumber: string;
    firstName: string;
    lastName: string;
    addresses: Address[];
}
