package com.mst.beans;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private String roomName; 
    
    @OneToMany(mappedBy = "room" ,fetch = FetchType.EAGER)
    @ToString.Exclude 
    private List<Course> courses;

    @OneToMany(mappedBy = "sRoom" , fetch = FetchType.EAGER)
    @ToString.Exclude 
    private Set<Student> students;
    
    private int capacity;
    
 // Add a method to check if the room has space for more students
    public boolean hasCapacity() {
        return this.capacity > 0;
    }
		
}
