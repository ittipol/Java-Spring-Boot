# Node.js 

## Prisma
https://github.com/prisma/prisma

``` bash
npm install prisma --save-dev

npx prisma

npx prisma init

npx prisma migrate dev --name init

npm install @prisma/client

# After you change your data model, you'll need to manually re-generate Prisma Client to ensure the code inside node_modules/.prisma/client gets updated:
npx prisma generate
# The prisma generate command reads your Prisma schema and updates the generated Prisma Client library inside node_modules/@prisma/client.
```

## Express

``` bash
npm install express dotenv
```

## TypeScript
> We’ll start by installing TypeScript as a dev dependency. Along with it, we’ll install the the @types declaration packages for Express and Node.js, which provide type definitions in the form of declaration files.

> Declaration files are predefined modules that describe the shape of JavaScript values, or the types present, for the TypeScript compiler. Type declarations are usually contained in files with a .d.ts extension. These declaration files are available for all libraries that were originally written in JavaScript, not TypeScript.

> The DefinitelyTyped GitHub repository maintains the TypeScript type definitions for use directly in Node.js and other JavaScript projects, so you don’t have to define these types from scratch. To add these types or the declaration files related to a particular library or a module, you have to look for the packages that start with the @types namespace.

``` bash
npm i -D typescript @types/express @types/node
```

## Types of status codes
Status codes are a set of universal web development codes utilized to create apps all over the world.

- Informational responses (100–199)
- Successful responses (200–299)
- Redirects (300–399)
- Client errors (400–499)
- Server errors (500–599)


### 1. 200 OK
The HTTP 200 OK response code implies a successful request.

Here is an example of this kind of HTTP response.

- GET: The response contains an entity that corresponds to the resource requested.
- POST: An entity that describes or contains the action’s result.
- HEAD: In the response, the entity-header fields related to the requested resource are sent without any message-body.

### 2. 201 Created
This indicates that the request was completed, and a new resource was created as a result. The URI(s) sent in the response entity can refer to the newly generated help, with a Location header field providing the most particular URI for the resource.

### 3. 204 No Content
This response is sent when the server has completed the request and does not need to return an entity-body, but wants updated metainformation. The answer may contain additional or updated metadata in entity-headers, which should be associated with the requested variant if present.

### 4. 400 Bad Request
When the server is unable to understand the request due to incorrect syntax, this response is returned.

### 5. 401 Unauthorized
Even though the HTTP standard specifies “unauthorized,” this response indicates “unauthenticated” logically. To get the requested response, the client must first authenticate itself.

This response code can also be used to ensure the user has the proper access to the resource.

### 6. 403 Forbidden
This response is gotten when the server refuses to provide the requested resource because the client does not have access permissions to the material; it is unauthorized. Unlike 401, the server is aware of the client’s identity.

### 7. 404 Not Found
This means the requested resource is unavailable on the server, or maybe the URL has been mistyped in the browser. This can also indicate that the endpoint is correct, but the resource does not exist in an API. This response may be used instead of 403 to conceal the existence of a resource from an unauthorized client.

### 8. 500 Internal Server Error
The server ran into an unanticipated problem that stopped it from completing the request.


### 9. 503 Service Not Available
This happens due to a sudden overload or server maintenance and it means the server cannot handle the request.

### 10. 504 Gateway Timeout
When the server is operating as a gateway and cannot promptly respond, this error response is returned.
