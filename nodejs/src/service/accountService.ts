import accountRepository from '../repository/accountRepository'
import { accountRequest, accountResponse } from '@/model/account'

const getAccount = async () => {
    const { getAccount } = accountRepository();

    let result: Array<accountResponse> = [];

    const accounts = await getAccount();

    accounts.forEach((value, index) => {

        const account: accountResponse = {
            id: value.id,
            accountNo: value.account_no,
            name: value.name,
            description: value.description
        };

        result.push(account);
    })

    return result;
}

const addAccount = async (body:any) => {
    const { addAccount, getAccountByAccountNo } = accountRepository();

    let result: accountResponse = {
        id: 0,
        accountNo: "",
        name: "",
        description: "",
    }

    if((body.accountNo === undefined) || (body.name === undefined)) {
        return result;
    }
    
    const account = await getAccountByAccountNo(body.accountNo)

    if (account !== null) {
        return result;
    }

    const accountData:accountRequest = {
        accountNo: body.accountNo,
        name: body.name,
        description: body.description
    }
    
    const addedAccount = await addAccount(accountData);

    if(addedAccount === null) {
        return result
    }

    result.id = addedAccount.id,
    result.accountNo = addedAccount.account_no
    result.name = addedAccount.name
    result.description = addedAccount.description

    return result
}

const accountService = () => {
    return {getAccount, addAccount}
}

export default accountService