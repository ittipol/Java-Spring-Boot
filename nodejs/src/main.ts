import { PrismaClient } from '@prisma/client'
import express from 'express'
import dotenv from 'dotenv'

import { getCategory } from './service/categoryService'

const prisma = new PrismaClient()

const main = async () => {

    dotenv.config()

    const app = express()
    const port = process.env.PORT

    // await prisma.account.create({
    //     data: {
    //         name: "New Name",
    //         account_no: "456-789-123"
    //     }
    // })

    // await prisma.category.createMany({
    //     data:[
    //         {
    //             name: "Category-A"
    //         },
    //         {
    //             name: "Category-B"
    //         }
    //     ]
    // })

    // const allUsers = await prisma.account.findMany()
    // console.log(allUsers)
    // console.table(allUsers)

    app.get("/health", (req, res) => {
        res.send("ok")
    })

    app.get("/category", async (req, res) => {
        const categories = await getCategory()
        res.json(categories)
    })

    // app.get("/account", async (req, res) => {
        
    // })

    // app.post("/account", async (req, res) => {
        
    // })

    app.listen(port, () => {
        console.log(`[server]: Server is running at http://localhost:${port}`)
    })

}

main()
.then(async () => {
    await prisma.$disconnect
})
.catch(async (e) => {
    console.error(e)
    await prisma.$disconnect
    process.exit(1)
})