package com.prescription.models;

import java.util.ArrayList;

public class PatientsService {
	private static ArrayList<Patient> patients;

    private DbAccess db = new DbAccess();

    public Patient get(String id) {
        Patient p = null;
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from patient where doctorID = '%s' ", id));
        for (ArrayList<String> row : temp) {
			p = new Patient(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4));
		}
        return p;
    }

    public ArrayList<Patient> getAll() {
    	ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from patient"));
        for (ArrayList<String> row : temp) {
        	
			patients.add(new Patient(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4)));
		}
        return patients;
    }

    public void save(Patient d) {
        if (d.getPatientID() == null) {
            db.updateQuery(String.format(" insert into dschedule values('%s','%s','%s','%s','%s') ", d.getPatientID(),d.getUsername(),d.getpName(),d.getpMail(),d.getpAddress()));
        }

        db.updateQuery(String.format("update patient set username='%s',pName='%s',pMail='%s',pAddress='%s' where patientID = '%s'",d.getUsername(),d.getpName(),d.getpMail(),d.getpAddress(),d.getPatientID()));
    }

    public boolean remove(String id) {
    	return db.updateQuery(String.format(" delete from dschedule where patientID = '%s' ",id));
    }
}
