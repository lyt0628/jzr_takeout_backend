run:
	mvn clean package -Dmaven.test.skip=true
	java -jar ./target/*.jar

test:
	mvn clean test

clean:
	mvn clean
push:
	git add .
	git commit -m "update"
	git push -u origin main

.PHONY: run clean test