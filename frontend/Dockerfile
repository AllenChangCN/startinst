FROM node:9.11.1-alpine
ENV HOST 0.0.0.0
EXPOSE 3000

RUN mkdir /app
WORKDIR /app
COPY . .
RUN yarn install && yarn build && chmod +x run.sh
CMD ["./run.sh"]
