package com.api.juridico.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("EMP_CONTRATANTE")
@Entity
public class EmpContratante extends Pessoa{
}
