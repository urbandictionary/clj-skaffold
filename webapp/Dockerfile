FROM clojure:openjdk-11-lein-slim-buster

WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
CMD ["lein", "run"]