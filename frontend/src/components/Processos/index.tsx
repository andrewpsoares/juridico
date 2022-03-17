import { Link } from "react-router-dom";
import { Processo } from "types/processo";
import Form from "pages/Processo/Form";

type Props = {
    processo: Processo;
}

function Processos({ processo }: Props) {

    return (
        <>
            <td>{processo.id}</td>
            <td>{processo.numero}</td>
            <td>{processo.autor.nome}</td>
            <td>{processo.vlrCausa}</td>
            <td>
                <Link to={`/processos/${processo.id}`}>
                    <div className="btn btn-warning fas fa-edit"></div>
                </Link>
            </td>
        </>
    );
}

export default Processos;