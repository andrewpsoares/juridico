import {ReactComponent as Arrow} from 'assets/img/arrow.svg'
import './style.css';

function Pagination() {
    return (
        <div className="dsmovie-pagination-container">
            <div className="dsmovie-pagination-box">
                <button className="dsmovie-pagination-button" disabled={true}>
                    {/*</button></div>onClick={() => onChange(page.number - 1)} >*/}
                    <Arrow />
                </button>
                <p>1 de 3</p>
                <button className="dsmovie-pagination-button" disabled={false}>
                {/*</div>onClick={() => onChange(page.number + 1)}>*/}
            <Arrow className="dsmovie-flip-horizontal" />
        </button>
        </div >
    </div >  
    );
}

export default Pagination;