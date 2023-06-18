import { PrismaClient } from '@prisma/client'
import express from 'express'
import dotenv from 'dotenv'

import categoryService from './service/categoryService'
import accountService from './service/accountService'

const prisma = new PrismaClient()

const main = async () => {

    dotenv.config()

    const app = express()
    const port = process.env.PORT

    app.get("/health", (req, res) => {
        res.send("ok")
    })

    app.get("/category", async (req, res) => {
        const { getCategory } = await categoryService()

        const categories = await getCategory()
        res.json(categories)
    })

    app.get("/account", async (req, res) => {
        const {getAccount} = accountService()

        getAccount()

        res.send("ok")

    })

    app.post("/account", async (req, res) => {
        
    })

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