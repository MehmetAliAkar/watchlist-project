package com.sisterslab.watchlistproject.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String name;
    private String userName;
    private String email;
    private String password;
}
