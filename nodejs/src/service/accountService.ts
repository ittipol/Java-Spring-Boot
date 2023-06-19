import accountRepository from '../repository/accountRepository'
import { accountRequest, accountResponse } from '@/entity/account'

const getAccount = async () => {
    const { getAccount } = accountRepository();

    const result = await getAccount();

    // result.forEach((value, index) => {})

    console.log('getAccount');
}

const addAccount = async (body:any): Promise<accountResponse> => {
    const { addAccount } = accountRepository();

    if((body.accountNo === undefined) || (body.name === undefined) || (body.description === undefined)) {
        // return
    }

    const accountData:accountRequest = {
        accountNo: body.accountNo,
        name: body.name,
        description: body.description
    };

    const result = await addAccount(accountData);

    return {
        id: result.id,
        accountNo: result.accountNo,
        name: result.name,
        description: result.description
    } as accountResponse;
}

const accountService = () => {
    return {getAccount, addAccount}
}

export default accountService