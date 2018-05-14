FROM node:9.11.1-alpine

RUN mkdir /app
WORKDIR /app
COPY . .
RUN yarn install && yarn build

CMD ["run.sh"]
