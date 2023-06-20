import accountRepository from '../repository/accountRepository'
import { accountRequest, accountResponse } from '@/entity/account'

const getAccount = async () => {
    const { getAccount } = accountRepository();

    let result: Array<accountResponse> = [];

    const accounts = await getAccount();

    accounts.forEach((value, index) => {

        const account: accountResponse = {
            id: value.id,
            accountNo: value.accountNo,
            name: value.name,
            description: value.description
        };

        result.push(account);
    })

    return result;
}

const addAccount = async (body:any) => {
    const { addAccount } = accountRepository();

    let result: accountResponse = {
        id: 0,
        accountNo: "",
        name: "",
        description: "",
    }

    if((body.accountNo === undefined) || (body.name === undefined) || (body.description === undefined)) {
        return result;
    }

    const accountData:accountRequest = {
        accountNo: body.accountNo,
        name: body.name,
        description: body.description
    }

    const account = await addAccount(accountData);

    if(account.id == 0) {
        return result
    }

    result.id = account.id,
    result.accountNo = account.accountNo
    result.name = account.name
    result.description = account.description

    return result
}

const accountService = () => {
    return {getAccount, addAccount}
}

export default accountService