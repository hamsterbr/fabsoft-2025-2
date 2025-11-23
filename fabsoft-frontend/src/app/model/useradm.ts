// fabsoft-frontend/src/app/model/useradm.ts

export class Useradm {
    matricula: number = 0;
    nomeCompleto: string = '';
    contato: string = '';

    constructor(matricula: number = 0, nomeCompleto: string = '', contato: string = '') {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.contato = contato;
    }
}