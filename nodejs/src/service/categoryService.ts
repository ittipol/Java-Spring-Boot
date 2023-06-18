import categoryRepository from "../repository/categoryRepository"

const getCategory = async () => {
    const { getCategory } = await categoryRepository()

    const categories = await getCategory()
    return categories
}

const categoryService = async () => {
    return { getCategory }
}

export default categoryService