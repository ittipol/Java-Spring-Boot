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