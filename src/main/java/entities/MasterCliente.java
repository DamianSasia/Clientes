/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Damian Sasia Ybar
 */
@Entity
@Table(name = "master_clientes")
@NamedQueries({
    @NamedQuery(name = "MasterCliente.findAll", query = "SELECT m FROM MasterCliente m"),
    @NamedQuery(name = "MasterCliente.findByCliId", query = "SELECT m FROM MasterCliente m WHERE m.cliId = :cliId"),
    @NamedQuery(name = "MasterCliente.findByCliNombres", query = "SELECT m FROM MasterCliente m WHERE m.cliNombres = :cliNombres"),
    @NamedQuery(name = "MasterCliente.findByCliApellido1", query = "SELECT m FROM MasterCliente m WHERE m.cliApellido1 = :cliApellido1"),
    @NamedQuery(name = "MasterCliente.findByCliApellido2", query = "SELECT m FROM MasterCliente m WHERE m.cliApellido2 = :cliApellido2"),
    @NamedQuery(name = "MasterCliente.findByCliFechaNacimiento", query = "SELECT m FROM MasterCliente m WHERE m.cliFechaNacimiento = :cliFechaNacimiento")})
public class MasterCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_id")
    private Integer cliId;
    @Size(max = 2147483647)
    @Column(name = "cli_nombres")
    private String cliNombres;
    @Size(max = 2147483647)
    @Column(name = "cli_apellido1")
    private String cliApellido1;
    @Size(max = 2147483647)
    @Column(name = "cli_apellido2")
    private String cliApellido2;
    @Size(max = 2147483647)
    @Column(name = "cli_fecha_nacimiento")
    private String cliFechaNacimiento;

    public MasterCliente() {
    }

    public MasterCliente(Integer cliId) {
        this.cliId = cliId;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliApellido1() {
        return cliApellido1;
    }

    public void setCliApellido1(String cliApellido1) {
        this.cliApellido1 = cliApellido1;
    }

    public String getCliApellido2() {
        return cliApellido2;
    }

    public void setCliApellido2(String cliApellido2) {
        this.cliApellido2 = cliApellido2;
    }

    public String getCliFechaNacimiento() {
        return cliFechaNacimiento;
    }

    public void setCliFechaNacimiento(String cliFechaNacimiento) {
        this.cliFechaNacimiento = cliFechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterCliente)) {
            return false;
        }
        MasterCliente other = (MasterCliente) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MasterCliente[ cliId=" + cliId + " ]";
    }

    public void setCliIdentificación(String identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCliFecha(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
