package com.api.juridico.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@DiscriminatorValue("ADVOGADO")
@Entity
public class Advogado extends Pessoa{

}
