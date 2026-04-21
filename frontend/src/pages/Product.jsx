import React, { useEffect, useState } from 'react'
import { deleteProduct, findAll } from '../service/ProductService';
import { Link } from 'react-router-dom';

function Product() {
  const [products, setProducts] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const data = loadProducts()
    .then((data) => {
      if(!data) throw new Error("Failed to fetch Products");
      setProducts(data);
    })
    .catch((err) => {setError(err)})
    .finally(() => {setLoading(false)});
  },[])

  //Fetch
  const loadProducts = async() => {
    return await findAll();
  }

  //Delete
  const handleDelete = async (id) => {
    const confirmDelete = window.confirm("Are you sure you want to delete this product?");
    if(!confirmDelete) return;

    try{
      const response = await deleteProduct(id);

      if(!response.ok) throw new Error("Failsed to delete product")

      setProducts(products.filter( (pro) => pro.id !== id));
      alert("Product deleted successfully!")
    }
    catch(err)
    {
      console.log(err);
      alert("Something went wrond while deleting product");
    }
  }

  return (
    <table className="w-full divide-y divide-gray-200 shadow-md rounded-lg overflow-hidden mt-2">

      <thead className="bg-gray-200">
        <tr>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Name
          </th>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Price
          </th>
           <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Category
          </th>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Quantity
          </th>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Status
          </th>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            <div className="flex justify-between items-center">
              <span>Actions</span>

              <div className="flex gap-2">

                <button className="p-2 bg-blue-300 rounded-lg">
                  <Link to="/createProduct">Create</Link>
                </button>
              </div>
            </div>

          </th>
        </tr>
      </thead>

      <tbody className="bg-white divide-y divide-gray-200">
        {products && products.length === 0 ? (
          <tr className="bg-white">
            <td
              colSpan={3}
              className="px-6 py-4 text-center text-sm text-gray-500"
            >
              There is no data to show
            </td>
          </tr>
        ) : (
          products.map((product) => (
            <tr key={product.id} className="hover:bg-gray-50 transition">
              <td className="px-6 py-4 text-gray-800">{product.name}</td>
              <td className="px-6 py-4 text-gray-600">{product.price}</td>
              <td className="px-6 py-4 text-gray-800">
                {product.category?.name || "No Category"}
              </td>
              <td className="px-6 py-4 text-gray-800">{product.quantity}</td>
              <td className="px-6 py-4 text-gray-800">{product.status}</td>
              <td className="px-6 py-4 flex gap-2">
                <Link
                to={`/editProduct/${product.id}`} 
                className="px-3 py-1 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition">
                  Edit
                </Link>
                <button  
                className="px-3 py-1 bg-red-500 text-white rounded-lg hover:bg-red-600 transition"
                onClick={() => handleDelete(product.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))
        )}
      </tbody>
</table>
  )
}

export default Product
