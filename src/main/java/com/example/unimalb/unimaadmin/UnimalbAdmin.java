package com.example.unimalb.unimaadmin;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table
public class UnimalbAdmin {
    @Id
    @SequenceGenerator(
            name = "UnimalbAdmin_sequence",
            sequenceName = "UnimalbAdmin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "UnimalbAdmin_sequence"
    )
    @ApiModelProperty(notes = "It show id of admin")
    private  Long id;
    @ApiModelProperty(notes = "It show full name of admin")
    private  String fullName;
    @ApiModelProperty(notes = "It show email of admin")
    private String email;
    @ApiModelProperty(notes = "It show password of admin")
    private  String pwd;

    public UnimalbAdmin() {
    }

    public UnimalbAdmin(Long id, String fullName, String email, String pwd) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.pwd = pwd;
    }

    public UnimalbAdmin(String fullName, String email, String pwd) {
        this.fullName = fullName;
        this.email = email;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UnimalbAdmin{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
