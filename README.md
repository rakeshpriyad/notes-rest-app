

1. To save Note


curl --user admin@gmail.com:password -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d "{'Title':'Note',"Note": 'ttt'}" http://localhost:8080/notes-rest-app/rest/notes/create


2. To update Note
curl --user admin@gmail.com:password -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT -d "{'Title':'Note Title',"Note": 'My Note'}" http://localhost:8080/notes-rest-app/rest/notes/update/4

3. To get all notes use following command: 

curl --user admin@gmail.com:password http://localhost:8080/notes-rest-app/rest/notes

4. To find Note by id use following command:

curl --user admin@gmail.com:password http://localhost:8080/notes-rest-app/rest/notes/1

where 1 is id for note

5. To delete Note by id use following command:

curl --user admin@gmail.com:password -X DELETE http://localhost:8080/notes-rest-app/rest/notes/delete/1

where 1 is id of Note