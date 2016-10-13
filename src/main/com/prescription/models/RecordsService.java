package com.prescription.models;

import java.util.ArrayList;

public class RecordsService {
	private static ArrayList<Records> records;

    private DbAccess db = new DbAccess();

    public Records get(String id) {
        Records r = null;
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from records where recordID = '%s' ", id));
        for (ArrayList<String> row : temp) {
			r = new Records(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6));
		}
        return r;
    }

    public ArrayList<Records> getAll() {
    	records.clear();
    	ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from records"));
        for (ArrayList<String> row : temp) {
        	
			records.add(new Records(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
		}
        return records;
    }

    public void save(Records r) {
        if (r.getRecordID() == null) {
            db.updateQuery(String.format(" insert into records values('%s','%s','%s','%s','%s','%s','%s') ", r.getRecordID(),r.getDoctorID(),r.getPatientID(),r.getDate(),r.getMedications(),r.getdRemarks(),r.getpRemarks()));
        }

        db.updateQuery(String.format("update reocords set doctorID='%s', patientID='%s', date='%s',medications='%s',dRemarks='%s',pRemarks='%s' where recordID = '%s'",r.getDoctorID(),r.getPatientID(),r.getDate(),r.getMedications(),r.getdRemarks(),r.getpRemarks(),r.getRecordID()));
    }

    public boolean remove(String id) {
    	return db.updateQuery(String.format(" delete from records where recordID = '%s' ",id));
    }
    
    public ArrayList<Records> dRecord(String u) {
    	records.clear();
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" SELECT * FROM records WHERE patientID in (select patientID from serviceschedule where accept='1' and doctorId in (SELECT DoctorID FROM doctor WHERE username='%s' ))", u));
        for (ArrayList<String> row : temp) {
			records.add(new Records(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
		}
        return records;
    }

}
