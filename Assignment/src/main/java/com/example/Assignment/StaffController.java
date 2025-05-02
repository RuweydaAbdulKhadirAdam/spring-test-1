package com.example.Assignment;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staffs/")
public class StaffController {
    private  final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    @GetMapping("all")
    public ResponseEntity<Collection<Staff>> getall(){
        HttpHeaders header1=new HttpHeaders();
        header1.add("Get All","Get All Staffs");
        Collection<Staff>staffCollection=staffService.getAllStaff();
        return  ResponseEntity.status(HttpStatus.FOUND).headers(header1).body(staffCollection);

    }
    @GetMapping("{id}")
    public Staff getStaffById(@PathVariable Long id){
        return staffService.GetStaffById(id);
    }
    @PostMapping
    public  Staff InsertStaff(@PathVariable Staff newStaff){
        return staffService.SaveStaff(newStaff);
    }
    @PostMapping("{id}")
    public Staff UpdateStaff(@PathVariable Long id,@RequestBody Staff newStaff){
        return  staffService.UpdateStaff(id,newStaff);
    }
    @DeleteMapping("{id}")
    public Staff Delete(@PathVariable Long id){
        return staffService.DeleteStaff(id);
    }
}
