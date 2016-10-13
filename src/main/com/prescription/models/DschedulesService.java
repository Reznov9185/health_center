package com.prescription.models;

import java.util.ArrayList;

public class DschedulesService {
	private static ArrayList<Dschedule> dschedules;

    private DbAccess db = new DbAccess();

    public Dschedule get(String id) {
        Dschedule d = null;
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from dschedule where doctorID = '%s' ", id));
        for (ArrayList<String> row : temp) {
			d = new Dschedule(row.get(0),row.get(1),row.get(2));
		}
        return d;
    }

    public ArrayList<Dschedule> getAll() 
    {	
    	dschedules.clear();
    	ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from dschedule"));
        for (ArrayList<String> row : temp) {
        	
			dschedules.add(new Dschedule(row.get(0),row.get(1),row.get(2)));
		}
        return dschedules;
    }

    public void save(Dschedule d) {
        if (d.getDoctorID() == null) {
            db.updateQuery(String.format(" insert into dschedule values('%s','%s','%s') ", d.getDoctorID(),d.getdChember(),d.getdTime()));
        }

        db.updateQuery(String.format("update dschedule set dChember='%s', dTime='%s' where doctorID = '%s'",d.getdChember(),d.getdTime(),d.getDoctorID()));
    }

    public boolean remove(String id) {
    	return db.updateQuery(String.format(" delete from dschedule where doctorID = '%s' ",id));
    }
    
    //for chamber view
    public ArrayList<Dschedule> dChember(String u) {
    	dschedules.clear();
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format("SELECT * FROM dschedule WHERE doctorID in (SELECT DoctorID FROM doctor WHERE username='%s'", u));
        for (ArrayList<String> row : temp) {
			dschedules.add(new Dschedule(row.get(0),row.get(1),row.get(2)));
		}
        return dschedules;
    }
}
