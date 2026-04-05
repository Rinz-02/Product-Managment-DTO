import React, { useState } from 'react'
import { create } from '../service/CategoryService';
import { useNavigate } from 'react-router-dom';

function CategroyCreate() {
  const [formData, setFormData] = useState( {
    name : "",
    description : ""
  })
  const navigate = useNavigate();

  //HandleChange
  const handleChange = (e) => {
    const {name,value} = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value
    }));
  }

  //HandleSubmit
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = await create(formData);
      
      if(!data) throw new Error("Create Failed");
      alert("Category crated successfully!");
      navigate("/category");
    }
    catch(error){
      console.log(error);
      alert("Error createing category");
    }
  }
  return (
    <div className="max-w-xl mx-auto mt-10 bg-white shadow-lg rounded-lg p-6">
      <h2 className="text-xl font-semibold text-gray-800 mb-4">
        Create Category
      </h2>

      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1">
            Name
          </label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            className="w-full px-3 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400 outline-none"
            required
          />
        </div>

        <div>
          <label className="block text-sm font-medium text-gray-700 mb-1">
            Description
          </label>
          <input
          type="text"
            name="description"
            value={formData.description}
            onChange={handleChange}
            className="w-full px-3 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400 outline-none"
          />
        </div>

        <div className="flex justify-end gap-2">
          <button
            type="button"
            onClick={() => navigate("/category")}
            className="px-4 py-2 bg-gray-300 rounded hover:bg-gray-400 transition"
          >
            Cancel
          </button>
          <button
            type="submit"
            className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 transition"
          >
            Create
          </button>
        </div>
      </form>
    </div>
  )
}

export default CategroyCreate
