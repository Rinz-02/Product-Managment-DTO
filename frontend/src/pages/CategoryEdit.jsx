import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { findById, update } from "../service/CategoryService";

function CategoryEdit() {
  const { id } = useParams(); 
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    id: "",
    name: "",
    description: "",
  });

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCategory = async () => {
        try {
            const data = await findById(id);

            if (!data) throw new Error("Failed to fetch category");

            setFormData({
                id: data.id || "undifined",
                name: data.name || "",
                description: data.description || "",
            });
        } catch (err) {
            console.error(err);
            alert("Error loading category");
        } finally {
            setLoading(false);
        }
    };
    if (id) {
        fetchCategory();
    }
}, [id]);

  // Handle input change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Submit update
  const handleSubmit = async (e) => {
    e.preventDefault();

    console.log("FormData:", formData);
    console.log("TYPE:", typeof formData);
    try {
      const response = await update(formData);

      if (!response.ok) throw new Error("Update failed");

      alert("Category updated successfully!");

      navigate("/category");
    } catch (error) {
      console.error(error);
      alert("Error updating category");
    }
  };

  if (loading) {
    return <p className="text-center py-6">Loading...</p>;
  }

  return (
    <div className="max-w-xl mx-auto mt-10 bg-white shadow-lg rounded-lg p-6">
      <h2 className="text-xl font-semibold text-gray-800 mb-4">
        Update Category
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
            Update
          </button>
        </div>
      </form>
    </div>
  );
}

export default CategoryEdit;
