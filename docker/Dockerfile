FROM openjdk:7
COPY . src
WORKDIR src
RUN javac src/Actions.java
RUN javac src/ErrorDialog.java
RUN javac src/LoadFiles.java
RUN javac src/SearchTerm.java
RUN javac src/TopNTerms.java
RUN javac src/Main.java
CMD ["java", "src.Main"]