import { Link } from "react-router-dom";
import { Processo } from "types/processo";
import { EditIcon } from 'components/buttons/EditIcon'
import { DeleteIcon } from "components/buttons/DeleteIcon";
import axios from "axios";
import { BASE_URL } from "utils/requests";
import './style.css'

type Props = {
    processo: Processo;
}

function Processos({ processo }: Props) {

    async function deleteProcesso(id: number) {
        await axios.delete(`${BASE_URL}/processos/${id}`);
        loadProcessos();
    }

    async function loadProcessos() {
        await axios.get(`${BASE_URL}/processos`);
        window.location.reload();
    }

    return (
        <>
            <td>{processo.id}</td>
            <td>{processo.numero}</td>
            <td>{processo.autor.nome}</td>
            <td>{processo.vlrCausa}</td>
            <div className="d-flex justify-content-end">
                <td>
                    <Link to={`/processos/${processo.id}`}>
                        <button className="btn processos-btn">
                            <EditIcon />
                        </button>
                    </Link>
                </td>
                <td>
                    <button className="btn processos-btn" onClick={() => deleteProcesso(processo.id)}><DeleteIcon /></button>
                </td>
            </div>
        </>
    );
}

export default Processos;