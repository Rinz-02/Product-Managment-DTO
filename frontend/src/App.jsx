import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Category from './pages/Category';
import Product from './pages/Product';
import CategoryEdit from './pages/CategoryEdit';
import Header from './components/Header';
import CategoryCreate from './pages/CategoryCreate';
import ProductCreate from './pages/ProductCreate';
import ProductEdit from './pages/ProductEdit';

function App() {
  return (
      <>
      <Header className="w-full" />
        <Routes>
        <Route path="/" element={<Home />} />
        
        <Route path="/category" element={<Category />} />
        <Route path="/editCategory/:id" element={<CategoryEdit/> }></Route>
        <Route path="/createCategory" element={<CategoryCreate />} />

        <Route path="/product" element={<Product />} /> 
        <Route path="/editProduct/:id" element={<ProductEdit />} />
        <Route path="/createProduct" element={<ProductCreate /> } />
      </Routes>
      </>
  );
}

export default App;
