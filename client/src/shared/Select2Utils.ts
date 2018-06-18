import { Select2OptionData } from 'ng2-select2';

export class Select2Utils {

    static transformaStringsEmSelectOptions(array: string[]): Select2OptionData[] {
        return array.map((valor: string, index) => ({id: index.toString(), text: valor}));
    }
}