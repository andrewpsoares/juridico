export type Processo = {
    id:         number;
    numero:     number;
    vlrCausa:   number;
    autor:      Autor;
}

export type Autor = {
    id: number; 
    nome:    String;
    cnpCnpj: String;
    tipoPessoa: String;
}

export type ProcessoPage = {
    content: Processo[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}