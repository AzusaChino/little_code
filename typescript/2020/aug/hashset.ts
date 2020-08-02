class MyHashSet {
    hash: { [key: number]: boolean } = {};

    constructor(key: number, val: boolean = true) {
        this.hash[key] = val;
    }

    add(key: number, val: boolean = true): void {
        this.hash[key] = val;
    }

    remove(key: number): void {
        delete this.hash[key];
    }

    contains(key: number): boolean {
        return this.hash[key];
    }
}