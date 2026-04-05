import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import { deleteCategory, findAll } from "../service/CategoryService";


function CategoryTable() {
  const [categories, setCategories] = useState([]); 
  const [loading, setLoading] = useState(true);     
  const [error, setError] = useState(null);      

  useEffect(() => {
    const data = loadCategories()
      .then((data) => {
        if (!data) throw new Error("Failed to fetch categories");
       setCategories(data);
      })
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  const loadCategories = async () => {
    return await findAll();
  }

  const handleDelete = async (id) => {
    const confirmDelete = window.confirm("Are you sure you want to delete this category?");
    if (!confirmDelete) return;

    try {
      const response = await deleteCategory(id);

      if (!response.ok) throw new Error("Failed to delete category");

      setCategories(categories.filter((cat) => cat.id !== id));

      alert("Category deleted successfully!");
    } catch (error) {
      console.error(error);
      alert("Something went wrong while deleting the category.");
    }
  };

  if (loading) {
    return <p className="text-center py-4">Loading...</p>;
  }

  if (error) {
    return <p className="text-center py-4 text-red-500">{error}</p>;
  }

  return (
    <table className="w-full divide-y divide-gray-200 shadow-md rounded-lg overflow-hidden mt-2">

      <thead className="bg-gray-200">
        <tr>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Name
          </th>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            Description
          </th>
          <th className="px-6 py-3 text-left text-sm font-semibold text-gray-700 uppercase tracking-wider">
            <div className="flex justify-between items-center">
              <span>Actions</span>

              <div className="flex gap-2">

                <button className="p-2 bg-blue-300 rounded-lg">
                  <Link to="/createCategory">Create</Link>
                </button>
              </div>
            </div>

          </th>
        </tr>
      </thead>

      <tbody className="bg-white divide-y divide-gray-200">
        {categories && categories.length === 0 ? (
          <tr className="bg-white">
            <td
              colSpan={3}
              className="px-6 py-4 text-center text-sm text-gray-500"
            >
              There is no data to show
            </td>
          </tr>
        ) : (
          categories.map((category) => (
            <tr key={category.id} className="hover:bg-gray-50 transition">
              <td className="px-6 py-4 text-gray-800">{category.name}</td>
              <td className="px-6 py-4 text-gray-600">{category.description}</td>
              <td className="px-6 py-4 flex gap-2">
                <Link
                to={`/editCategory/${category.id}`} 
                className="px-3 py-1 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition">
                  Edit
                </Link>
                <button  
                className="px-3 py-1 bg-red-500 text-white rounded-lg hover:bg-red-600 transition"
                onClick={() => handleDelete(category.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))
        )}
      </tbody>
</table>
  );
}

export default CategoryTable;