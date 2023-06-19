// type account = {
//     name: string
// }

export interface accountEntity {
    id: number
    accountNo: string
    name: string
    description?: string | null
}

export interface accountRequest {
    accountNo: string
    name: string
    description?: string | null
}

export interface accountResponse {
    id: number
    accountNo: string
    name: string
    description?: string | null
}