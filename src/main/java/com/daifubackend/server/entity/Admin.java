package com.daifubackend.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wd_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "created_at")
    private int createdAt;

    @Column(name = "updated_at")
    private int updatedAt;

    @Column(name = "google")
    private String google;

    @Column(name = "state")
    private boolean state;

    @Column(name = "created_ip")
    private String createdIp;

    @Column(name = "created_by_uid")
    private Long createdByUid;

    @Column(name = "created_by_name")
    private String createdByName;
}