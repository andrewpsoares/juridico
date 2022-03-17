import FormProcesso from "components/FormProcesso";
import { useParams } from "react-router-dom";

function Form() {

  const params = useParams();

  return (
    <FormProcesso id={`${params.processoId}`} />
  );
}

export default Form;