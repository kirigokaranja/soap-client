# SoapApplication
A SOAP based application

Run at http://localhost:7000/ws/universities.wsdl

##To test with the requests:

curl --header "content-type: text/xml" -d @request-2.xml http://localhost:7000/ws

##The application can:

.Get university by name

.Get university by location

.Get all universities