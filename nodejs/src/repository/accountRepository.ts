import { PrismaClient } from '@prisma/client'
import { accountRequest } from '@/model/account'

const prisma = new PrismaClient();

const getAccount = async () => {
    const accounts = await prisma.account.findMany();
    return accounts;
}

const getAccountById = async (id: number) => {
    
    const account = await prisma.account.findFirst({
        where: {
            id: {
                equals: id
            }
        }
    });

    return account;
}

const getAccountByAccountNo = async (accountNo: string) => {
    
    const account = await prisma.account.findFirst({
        where: {
            account_no: {
                equals: accountNo
            }
        }
    });

    return account;
}

const addAccount = async (data:accountRequest) => {

    const result = await prisma.account.create({
        data: {
            account_no: data.accountNo,
            name: data.name,
            description: data.description
        }
    })

    return result;
}

const accountRepository = () => {
    return { getAccount, getAccountById, getAccountByAccountNo, addAccount };
}

export default accountRepository


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