package org.studyeasy.SpringBlog.util.email;

import lombok.Data;

@Data
public class emailDetails {
     
    private String recipient;
    private String msgBody;
    private String subject;
}
