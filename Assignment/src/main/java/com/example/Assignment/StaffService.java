package com.example.Assignment;

import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    Map<Long,Staff> staffs = new ConcurrentHashMap<>();
    private AtomicLong autoid = new AtomicLong();

    public Collection<Staff>getAllStaff(){
        return staffs.values();
    }
    public Staff GetStaffById(Long id ){return staffs.get(id);}
    public Staff SaveStaff(Staff newStaff){
        Long staffId =newStaff.id() !=null
                ? newStaff.id() :autoid.incrementAndGet();

        Staff staffSave = new Staff(staffId,newStaff.name(),newStaff.role());
        return staffs.put(staffId,staffSave);
    }
    public  Staff UpdateStaff(Long id,Staff newStaff){
        if(staffs.containsKey(id)){
            Staff updatedStaff =new Staff(id,newStaff.name(),newStaff.role());
            staffs.put(id,updatedStaff);
            return updatedStaff;
        }
        return null;
    }
    public Staff DeleteStaff(Long id){return staffs.remove(id);}
}
