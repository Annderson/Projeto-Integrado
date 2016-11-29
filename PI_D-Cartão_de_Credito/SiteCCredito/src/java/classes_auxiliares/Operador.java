/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes_auxiliares;

import java.util.Objects;

/**
 *
 * @author anderson
 */
public class Operador extends Cliente{
    
    private Long ro;
   
    public Operador() {
        super();
    }

    public Long getRo() {
        return ro;
    }

    public void setRo(Long ro) {
        this.ro = ro;
    }
  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operador other = (Operador) obj;
        
        if (!Objects.equals(this.ro, other.ro)) {
            return false;
        }
        return true;
    }
    
    
    
}
