FROM clojure:openjdk-11-lein-slim-buster

WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
CMD ["lein", "run"]
# RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
# CMD ["java", "-jar", "app-standalone.jar"]