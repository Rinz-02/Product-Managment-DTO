const API_URL = "http://localhost:8080/api/category";

export const findAll = async () => {
    const response = await fetch(`${API_URL}/findAll`);
    return response.json();
}

export const findById = async (id) => {
    const response = await fetch(`${API_URL}/edit/${id}`);
    return response.json();
}

export const create = async(data) => {
    const response = await fetch(`${API_URL}/create`, {
        method : "POST",
        headers : {
            "Content-Type" : "application/json",
        },
        body : JSON.stringify(data)
    });
    return response.json();
}

export const update = async (formData) => {
    const response = await fetch(`${API_URL}/edit`, {
        method : "PUT",
        headers : {
            "Content-Type" : "application/json",
        },
        body : JSON.stringify(formData)

    });
    return response;
} 

export const deleteCategory = async (id) => {
    return await fetch(`${API_URL}/delete/${id}`, {
        method : "DELETE"
    })
}
