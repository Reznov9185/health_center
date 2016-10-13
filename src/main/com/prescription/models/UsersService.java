package com.prescription.models;

import java.io.*;
import java.util.ArrayList;

public class UsersService {
	private static ArrayList<User> users;

    private DbAccess db = new DbAccess();

    public User get(String id) {
        User user = null;
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from user where usename = '%s' ", id));
        for (ArrayList<String> row : temp) {
			user = new User(row.get(0),row.get(1),row.get(2));
		}
        return user;
    }

    public ArrayList<User> getAll() {
    	ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from user"));
        for (ArrayList<String> row : temp) {
        	
			users.add(new User(row.get(0),row.get(1),row.get(2)));
		}
        return users;
    }

    public void save(User d) {
        if (d.getUsername() == null) {
            db.updateQuery(String.format(" insert into user values('%s','%s','%s') ", d.getUsername(),d.getPassword(),d.getUsertype()));
        }

        db.updateQuery(String.format("update user set password='%s' where username='%s' &&  usertype= '%s'",d.getPassword(),d.getUsername(),d.getUsertype()));
    }

    public boolean remove(String id) {
    	return db.updateQuery(String.format(" delete from user where username = '%s' ",id));
    }
    
    public User checkAuth(User u)
    {
         System.out.println(String.format(" select * from user where username = '%s' && password='%s' ", u.getUsername(),u.getPassword()));
    	 ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from user where username = '%s' && password='%s' ", u.getUsername(),u.getPassword()));
         System.out.println("Size is " + temp.size());
         if(temp.size()==0)
        	 return null;
         else
        	 return u;
    }
}
