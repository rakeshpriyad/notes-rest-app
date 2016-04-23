
RESTful API for a “notes” application:

To setup do following:

1. Import the project into eclipse as maven project and
change the username and password of mysql in https://github.com/rakeshpriyad/notes-rest-app/blob/master/src/main/resources/hibernate.cfg.xml
2. To ensure the user is inserted into mysql I have done following in controller
public NotesController(){
		//just to ensure user is entered into DB when this controller is used
		String email="admin@gmail.com";
		String password="password";
		
		UserService userService=new UserService();
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		
		User foundUser=userService.findUserByEmail(email);
		if(foundUser==null){
			userService.save(user);
		}
	}

	
	It will insert the one user with email admin@gmail.com
Although it is not needed if I write the UserService for inserting data to User table

1. To save Note use the following command:

curl --user admin@gmail.com:password -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d "{'Title':'Note',"Note": 'Note'}" http://localhost:8080/notes-rest-app/rest/notes/create

2. To update Note use the following command:
curl --user admin@gmail.com:password -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT -d "{'Title':'Note Title',"Note": 'My Note'}" http://localhost:8080/notes-rest-app/rest/notes/update/4

3. To get all notes use following command: 

curl --user admin@gmail.com:password http://localhost:8080/notes-rest-app/rest/notes

4. To find Note by id use following command:

curl --user admin@gmail.com:password http://localhost:8080/notes-rest-app/rest/notes/1

where 1 is id for note

5. To delete Note by id use following command:

curl --user admin@gmail.com:password -X DELETE http://localhost:8080/notes-rest-app/rest/notes/delete/1

where 1 is id of Note