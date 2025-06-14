package org.studyeasy.SpringBlog.models;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Authority {
    
    @Id
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Authority [id=" + id + ", name=" + name + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
