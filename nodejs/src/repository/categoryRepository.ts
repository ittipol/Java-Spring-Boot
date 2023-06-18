import { PrismaClient } from '@prisma/client'

const prisma = new PrismaClient()

export const repoGetCategory = async () => {
    const categories = await prisma.category.findMany()
    return categories
}