import React from 'react'
import { Link } from 'react-router-dom'

function Header() {
  return (
    <>   
        <div className="bg-blue-600 text-white py-6 shadow-md w-full relative flex items-center">
            <div className="pl-4 ">
                <Link to="/" className="p-2 bg-white rounded-lg text-blue-600">
                Home
                </Link>
            </div>
            <h1 className="absolute left-1/2 transform -translate-x-1/2 text-3xl font-semibold tracking-wide">
                Product-Management-DTO
            </h1>
        </div>
    </>
  )
}

export default Header
