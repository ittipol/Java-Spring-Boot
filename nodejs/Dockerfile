###################
FROM node:18-alpine As development

WORKDIR /var/www

COPY package*.json ./

RUN npm ci

###################
FROM node:18-alpine As build

WORKDIR /var/www

COPY package*.json ./

COPY --from=development /var/www/node_modules ./node_modules

COPY . .

RUN npm run build

ENV NODE_ENV production

RUN npm ci --omit=dev && npm cache clean --force

###################
FROM node:18-alpine As production

WORKDIR /var/www

COPY --from=build /var/www/package*.json ./
COPY --from=build /var/www/node_modules ./node_modules
COPY --from=build /var/www/build ./build

EXPOSE 4000

CMD [ "npm", "start" ]