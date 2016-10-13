package com.prescription.models;

import java.util.ArrayList;

public class ServiceSchedulesService {
	private static ArrayList<ServiceSchedule> serviceSchedules;

    private DbAccess db = new DbAccess();

    public ServiceSchedule get(String id) {
        ServiceSchedule s = null;
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from serviceschedule where schedule = '%s' ", id));
        for (ArrayList<String> row : temp) {
			s = new ServiceSchedule(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6));
		}
        return s;
    }

    public ArrayList<ServiceSchedule> getAll() {
    	serviceSchedules.clear();
    	ArrayList<ArrayList<String>> temp = db.executeQuery(String.format(" select * from serviceschedule"));
        for (ArrayList<String> row : temp) {
        	
			serviceSchedules.add(new ServiceSchedule(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
		}
        return serviceSchedules;
    }

    public void save(ServiceSchedule r) {
        if (r.getScheduleID() == null) {
            db.updateQuery(String.format(" insert into serviceschedule values('%s','%s','%s','%s','%s','%s','%s') ", r.getScheduleID(),r.getDoctorID(),r.getPatientID(),r.getdTime(),r.getdDate(),r.getdChember(),r.getAccept()));
        }

        db.updateQuery(String.format("update serviceschedule set doctorID='%s', patientID='%s', dTime='%s',dDate='%s',dChember='%s',accept='%s' where scheduleID = '%s'",r.getDoctorID(),r.getPatientID(),r.getdTime(),r.getdDate(),r.getdChember(),r.getAccept(),r.getScheduleID()));
    }
    public boolean remove(String id) {
    	return db.updateQuery(String.format(" delete from serviceschedule where recordID = '%s' ",id));
    }

    public ArrayList<ServiceSchedule> dRequest(String u) {
    	serviceSchedules.clear();
        ArrayList<ArrayList<String>> temp = db.executeQuery(String.format("select * from serviceschedule where accept='0' and doctorID in (SELECT DoctorID FROM doctor WHERE username='%s')", u));
        for (ArrayList<String> row : temp) {
			serviceSchedules.add(new ServiceSchedule(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6)));
		}
        return serviceSchedules;
    }
}
