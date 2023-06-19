import { PrismaClient } from '@prisma/client'

const prisma = new PrismaClient();

const getCategory = async () => {
    const categories = await prisma.category.findMany();
    return categories;
}

const categoryRepository = () => {
    return { getCategory };
}

export default categoryRepository