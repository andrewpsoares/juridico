import Pagination from "components/Pagination";
import Processos from "components/Processos";
import axios from "axios";
import { BASE_URL } from "utils/requests";

function Listing() {

    axios.get(`${BASE_URL}/processos`).then(response => {
        console.log(response.data);
    })

    return (
        <>
            <Pagination />
            <div className="col-md-12">
                <a className="btn btn-primary margin-top">Incluir Novo Processo</a>
            </div>            
                <Processos />
        </>
    )
}

export default Listing;