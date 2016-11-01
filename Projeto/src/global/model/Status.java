/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author urielcaire
 */

@Entity
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idStatus;
    
    @Column
    private String status;

    public Status(String status) {
        this.status = status;
    }

    public Status() {
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
