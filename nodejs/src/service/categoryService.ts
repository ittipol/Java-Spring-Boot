import { repoGetCategory } from "../repository/categoryRepository"

export const getCategory = async () => {
    const categories = await repoGetCategory()
    return categories
}