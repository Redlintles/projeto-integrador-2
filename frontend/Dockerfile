FROM node:latest


WORKDIR /app


RUN apt-get update && apt-get install -y netcat-traditional curl


COPY package.json .
COPY yarn.lock .

RUN npm install

COPY . .


COPY ./scripts/wait-for-it.sh /usr/local/bin/wait-for-it.sh
RUN chmod +x ./scripts/wait-for-it.sh

CMD ["/usr/local/bin/wait-for-it.sh","proxy:80","npm","run","dev"]





