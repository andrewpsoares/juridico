import Pagination from "components/Pagination";
import Processos from "components/Processos";
import axios from "axios";
import { BASE_URL } from "utils/requests";
import { useEffect, useState } from "react";
import { ProcessoPage } from "types/processo";
import { Link } from "react-router-dom";

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);
    const [page, setPage] = useState<ProcessoPage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/processos?size=5&page=${pageNumber}&sort=id`).then(response => {
            console.log(response);
            const data = response.data as ProcessoPage;
            setPage(data);
        })
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <Pagination page={page} onChange={handlePageChange} />
            <div className="col-md-12">
                <Link to={`/processos/form`}>
                    <div className="btn btn-primary margin-top">Incluir Novo Processo</div>
                </Link>
            </div>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Número</th>
                            <th scope="col">Autor</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Editar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content.map(processo => (
                            <tr key={processo.id}>
                                <Processos processo={processo} />
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default Listing;