import './App.css';
import AddItem from './components/AddItem';
import Navbar from './components/Navbar';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <>
    <Navbar />
    <AddItem />
    
    </>
  );
};

export default App;
