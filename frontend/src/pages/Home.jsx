import React from 'react';
import { Link } from 'react-router-dom';

export function Home() {
    return (
      <>
        <div className="flex justify-center gap-6 py-4 pt-20">
            <Link
                to="/category"
                className="text-gray-800 font-medium px-5 py-2 rounded-lg shadow-sm hover:bg-blue-600 hover:text-white transition transform hover:-translate-y-0.5"
            >
                Category
            </Link>
            <Link
                to="/product"
                className="text-gray-800 font-medium px-5 py-2 rounded-lg shadow-sm hover:bg-blue-600 hover:text-white transition transform hover:-translate-y-0.5"
            >
                Product
            </Link>
        </div>
      </>
    )
  }

export default Home
