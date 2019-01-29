package com.bonc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="tableName")
public class We {
@Id
@GeneratedValue(generator = "idsSynLogGenerator")
@GenericGenerator(name = "idsSynLogGenerator", strategy = "identity")
@Column(name="id")
String id;
@Column(name="name")
String name;
}


