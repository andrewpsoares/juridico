package com.api.juridico.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("AUTOR")
@Entity
public class Autor extends Pessoa{
}
