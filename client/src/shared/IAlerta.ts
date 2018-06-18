export interface IAlerta {
    id: string;
    label: string;
    sobre: string;
    descricao: string;
    pontoDeVenda: string;
    dataCadastro: Date;
    margem?: number;
    flTipo: number;
    corTitulo?: string;
    
}