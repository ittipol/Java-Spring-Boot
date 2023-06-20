import { PrismaClient } from '@prisma/client'
import { accountRequest, accountEntity, accountResponse } from '@/entity/account'

const prisma = new PrismaClient();

const getAccount = async () => {
    let result: Array<accountEntity> = [];

    const accounts = await prisma.account.findMany();

    accounts.forEach((value, index) => {

        const account: accountEntity = {
            id: value.id,
            accountNo: value.account_no,
            name: value.name,
            description: value.description
        }

        result.push(account)
    })

    return result;
}

const addAccount = async (data:accountRequest): Promise<accountEntity> => {

    const result = await prisma.account.create({
        data: {
            account_no: data.accountNo,
            name: data.name,
            description: data.description
        }
    })
    .then(value => {
        console.log(value)

        return {
            id: value.id,
            accountNo: value.account_no,
            name: value.name,
            description: value.description
        } as accountEntity

    })
    .catch(reason => {
        console.log(reason)

        return {
            id: 0,
            accountNo: "",
            name: "",
            description: "",
        } as accountEntity
    });

    return result;
}

const categoryRepository = () => {
    return { getAccount, addAccount };
}

export default categoryRepository


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