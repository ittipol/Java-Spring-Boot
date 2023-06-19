import categoryRepository from "../repository/categoryRepository"

const getCategory = async () => {
    const { getCategory } = categoryRepository()

    const categories = await getCategory()
    return categories
}

const categoryService = () => {
    return { getCategory }
}

export default categoryService