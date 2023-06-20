import { PrismaClient } from '@prisma/client'
import express from 'express'
import bodyParser from 'body-parser';
import dotenv from 'dotenv'

import categoryService from './service/categoryService'
import accountService from './service/accountService'

import { accountRequest } from './entity/account';

const prisma = new PrismaClient()

const main = async () => {

    dotenv.config()

    const app = express()
    const port = process.env.PORT

    // parse application/x-www-form-urlencoded
    // app.use(bodyParser.urlencoded({ extended: false }))

    // parse application/json
    app.use(bodyParser.json())

    app.get("/health", (req, res) => {
        res.send("ok")
    })

    app.get("/category", async (req, res) => {
        const { getCategory } = categoryService();

        const result = await getCategory();
        res.status(200).json(result);
    })

    app.get("/account", async (req, res) => {
        const { getAccount } = accountService();

        const result = await getAccount();
        res.status(200).json(result);
    })

    // app.get("/account/:accountNo", async (req, res) => {
    //     // const { getAccount } = accountService()
    //     res.send(req.params.accountNo)
    // })

    app.post("/account", async (req, res) => {
        const { addAccount } = accountService();

        console.table(req.body)
        const result = await addAccount(req.body);

        res.status(201).json(result);
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