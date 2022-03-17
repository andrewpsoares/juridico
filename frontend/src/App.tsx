import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from 'pages/Processo/Listing';
import Navbar from "components/Navbar";
import Form from "pages/Processo/Form";
//import NewForm from "pages/Processo/Form";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/processos" element={<Listing />} />
        {/*<Route path="/processos" element={<NewForm />} />*/}
        <Route path="/processos">
          <Route path=":processoId" element={<Form />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
