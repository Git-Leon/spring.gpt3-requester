portNumber=8080
./kill-port.sh $portNumber
mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=$portNumber'