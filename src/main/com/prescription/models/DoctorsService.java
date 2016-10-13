package com.prescription.models;

import java.util.*;

public class DoctorsService {
	private static ArrayList<Doctor> doctors;

    private DbAccess db = new DbAccess();

    public Doctor get(String id) {
        Doctor d = null;
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from doctor where doctorID = '%s' ", id));
        for (ArrayList<String> row : temp) {
			d = new Doctor(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6),row.get(7));
		}
        return d;
    }

    public ArrayList<Doctor> getAll() {
    	doctors.clear();
    	ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from doctor"));
        for (ArrayList<String> row : temp) {
        	
			doctors.add(new Doctor(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6),row.get(7)));
		}
        return doctors;
    }

    public void save(Doctor doctor) {
        if (doctor.getDoctorID() == null) {
            db.updateQuery(String.format(" insert into doctor values('%s','%s','%s','%s','%s','%s','%s','%s') ", doctor.getDoctorID(),doctor.getUsername(),doctor.getdName(),doctor.getdMail(),doctor.getdAddress(),doctor.getdDegrees(),doctor.getdSubject(),doctor.getdExperience()));
        }

        db.updateQuery(String.format("update doctor set username='%s', dName='%s', dMail='%s',dAddress='%s',dDegrees='%s',dSubject='%s',dExperience='%s' where doctorID = '%s'",doctor.getUsername(),doctor.getdName(),doctor.getdMail(),doctor.getdAddress(),doctor.getdDegrees(),doctor.getdSubject(),doctor.getdExperience(),doctor.getDoctorID()));
    }

    public boolean remove(String id) {
    	return db.updateQuery(String.format(" delete from doctor where doctorID = '%s' ",id));
    }
    
    public ArrayList<Doctor> dAbout(String u) {
    	doctors.clear();
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from doctor where username = '%s' ", u));
        for (ArrayList<String> row : temp) {
			doctors.add(new Doctor(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6),row.get(7)));
		}
        return doctors;
    }

}
