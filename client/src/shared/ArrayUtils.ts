export class ArrayUtils {

    static unique<T>(array: T[]): T[] {
        return Array.from(new Set(array));
    } 

    static isEmpty(array: any[]) {
        return array.length === 0;
    }
}