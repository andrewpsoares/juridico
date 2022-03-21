import axios, { AxiosRequestConfig } from "axios";
import { ChangeEvent, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Autor, Processo } from "types/processo";
import { BASE_URL } from "utils/requests";

type Props = {
    id: string;
}

function FormProcesso({ id }: Props) {

    const navigate = useNavigate();
    //const [autor, setAutor] = useState<Autor>();
    const [processo, setProcesso] = useState<Processo>({
        id: 0,
        numero: 0,
        vlrCausa: 0.0,
        autor: {
            id: 0,
            nome: '',
            cpfCnpj: '',
            tipoPessoa: 'AUTOR'
        }
    });

    useEffect(() => {
        if ((id !== undefined) && (id !== 'form')) {
            findProcesso(id)
        }
    }, [id])

    /*useEffect(() => {
        axios.get(`${BASE_URL}/processos/${id}`)
            .then(response => {
                setProcesso(response.data)
            });
    }, [id]);*/

    function onChange(e: ChangeEvent<HTMLInputElement>) {
        setProcesso({
            ...processo,
            [e.target.name]: e.target.value,
        });
        console.log(e.target.name + ':' + e.target.value);
    }

    async function onSubmit(e: ChangeEvent<HTMLFormElement>) {
        e.preventDefault();

        const config: AxiosRequestConfig = {
            baseURL: BASE_URL,
            method: 'POST',
            url: '/processos',
            data: {
                "numero": (e.target as any).numero.value,
                "autor": {
                    "nome": (e.target as any).nome.value,
                    "cpfCnpj": (e.target as any).cpfCnpj.value,
                    "tipoPessoa": processo.autor.tipoPessoa
                },
                "vlrCausa": (e.target as any).vlrCausa.value
            }
        }
        console.log(config);
        axios(config).then(response => {
            navigate("/processos");
        });

        /* const response = await axios.post(`${BASE_URL}/processos`, processo);
         console.log(response);*/
    }

    async function findProcesso(id: String) {
        const response = await axios.get(`${BASE_URL}/processos/${id}`)
        setProcesso(response.data)
    }

    return (
        <>
            <div className="container">
                <div className="row">
                    <div className="col-md-12 titulo">
                        <h2>Editar </h2>
                    </div>
                </div>
                <div className="row border">
                    <form className="row g-3" onSubmit={onSubmit}>
                        <input type="hidden" />
                        <div className="col-md-6">
                            <label className="form-label">Núm. Processo</label>
                            <input type="text" className="form-control" name="numero"
                                value={processo.numero}
                                onChange={(e: ChangeEvent<HTMLInputElement>) => onChange(e)}
                                placeholder="Digite o nome da empresa contratada" required />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Valor da Causa</label>
                            <input type="text" className="form-control" name="vlrCausa"
                                value={processo.vlrCausa}
                                onChange={(e: ChangeEvent<HTMLInputElement>) => onChange(e)}
                                placeholder="Digite o valor da causa" required />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Autor</label>
                            <input type="text" className="form-control" name={processo.autor.nome}
                                value={processo.autor.nome}
                                onChange={(e) => onChange(e)}
                                placeholder="Digite o nome do autor do processo" required />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">CPF / CNPJ</label>
                            <input type="text" className="form-control" name={processo.autor.cpfCnpj}
                                value={processo.autor.cpfCnpj}
                                onChange={(e: ChangeEvent<HTMLInputElement>) => onChange(e)}
                                placeholder="Digite o número do cpf/cnpj" required />
                        </div>
                        {/*<div className="col-md-3">
                            <label className="form-label">Início do Contrato</label>
                            <input type="date" className="form-control" id="dtIni" required />
                        </div>
                        <div className="col-md-3">
                            <label className="form-label">Término do Contrato</label>
                            <input type="date" className="form-control" id="dtFim" required />
                        </div>
                        <div className="col-md-6">
                            <label className="form-label">Objeto</label>
                            <input type="text" className="form-control" id="objeto" />
                        </div>
                        <div className="col-12">
                            <label className="form-label">Observação</label>
                            <textarea className="form-control" id="Observacao"
                                placeholder="Digite uma observação" ></textarea>
                        </div>
    <div>*/}
                        <button type="submit" className="btn btn-primary col-md-1">Salvar</button>
                        {/*<button type="button" className="btn btn-secondary"
                  onclick="'if(confirm(\'Deseja descartar o cadastro?\')) { window.location.href = \'' +
  @{/contratos} + '\' } '"></a>Cancelar</button></form>
  </div>
                        </div>*/}
                    </form>
                </div>
            </div>
        </>
    );
}

export default FormProcesso;