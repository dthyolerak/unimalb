package com.example.unimalb.unimaadmin;

import com.example.unimalb.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminReposistory adminReposistory;
    @Autowired
    public AdminService(AdminReposistory adminReposistory) {
        this.adminReposistory = adminReposistory;
    }

    public List<UnimalbAdmin> getUnimalbAdmin(){
        return  adminReposistory.findAll();
    }

    public void deleteAdmin(Long adminId) {
         boolean idExists = adminReposistory.existsById(adminId);
         if(!idExists){
             throw  new IllegalStateException(
                     "admin with id " +adminId +" does not exists"
             );
         }

         adminReposistory.deleteById(adminId);
    }
    @Transactional
    public void UpdateAdmin(Long adminId, String email, String fullName) {
        UnimalbAdmin unimalbAdmin =adminReposistory.findById(adminId)
                .orElseThrow(() ->new IllegalStateException(
                                "student with id " + adminId + " does not exist"
                        )
                );
        if (fullName != null && fullName.length()>0 && !Objects.equals(unimalbAdmin.getFullName(), fullName)){
            unimalbAdmin.setFullName(fullName);
        }
        if (email != null && email.length() > 0 && !Objects.equals(unimalbAdmin.getEmail(), email)){
            Optional<UnimalbAdmin> findAdminByEmail = adminReposistory.findAdminByEmail(email);

            if (findAdminByEmail.isPresent()){
                throw  new IllegalStateException("Email taken");
            }

            unimalbAdmin.setEmail(email);
        }


}

    public void addNewAdmin(UnimalbAdmin unimalbAdmin) {
        Optional<UnimalbAdmin> findAdminByEmail=  adminReposistory.findAdminByEmail(unimalbAdmin.getEmail());
        if (findAdminByEmail.isPresent()){
            throw new IllegalStateException(
                    "Email already taken"
            );
        }
        adminReposistory.save(unimalbAdmin);
    }
    }
