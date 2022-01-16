package com.example.unimalb.unimaadmin;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin")
public class AdminController {
    private  final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @ApiOperation(value = "It Return  all the unima-lb admin ")
    @GetMapping
    public List<UnimalbAdmin> getUnimalbAdmin(){
       return adminService.getUnimalbAdmin();
    }
    @ApiOperation(value = "For deleting admin, by providing id eg 1,2 etc. but if provided id does not exist it throw error  ")
    @DeleteMapping(path = "{adminId}")
    public void  deleteAdmin(@PathVariable("adminId") Long adminId){
        adminService.deleteAdmin(adminId);
    }
    @ApiOperation(value = "Usered for interting data in json format")
    @PostMapping
    public void addNewAdmin(@RequestBody UnimalbAdmin unimalbAdmin){
        adminService.addNewAdmin(unimalbAdmin);
    }
    @ApiOperation(value = "For updating admin, by providing id and followed by parameter eg email=yourname@domain.com etc. but if provided id does not exist it throw error and email already taken it throw error ")
    @PutMapping(path = "{adminId}")
    public void updateAdmin(
            @PathVariable("adminId") Long adminId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String fullName

    ){
        adminService.UpdateAdmin(adminId,email, fullName);
    }
}
