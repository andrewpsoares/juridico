import { Link } from "react-router-dom";
import { idText } from "typescript";

function Processos() {

    const processo = {
        id: 1,
        numero: 9999,
        vlrCausa: 15000.00
    }


    return (
        <div>
            {/*<table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>{processo.id}</td>
                        <td>{processo.numero}</td>
                        <td>{processo.vlrCausa}</td>
                        <td>
                            <Link to={`/form/${processo.id}`}>
                                <a className="btn btn-warning fas fa-edit"></a>
                            </Link>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td colSpan={2}>Larry the Bird</td>
                        <td>@twitter</td>
                    </tr>
                </tbody>
    </table>*/}
        </div>
    );
}

export default Processos;