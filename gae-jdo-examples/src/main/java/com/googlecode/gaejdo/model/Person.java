/**
 *
 * Copyright (c) 2011 Try Catch Software, LLC.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Try Catch Software, LLC.
 *
 */
package com.googlecode.gaejdo.model;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.FetchGroups;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Version;
import javax.jdo.annotations.VersionStrategy;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
@Version(strategy = VersionStrategy.VERSION_NUMBER, column = "VERSION", 
         extensions = { @Extension(vendorName = "datanucleus", key = "field-name", value = "version") })
@FetchGroups( { @FetchGroup(name = "findWithWithAddresses", members = {
      @Persistent(name = "addresses") }) })    
public class Person implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id;

  @Persistent
  private Integer version;

  @Persistent
  private String firstName;
  
  @Persistent
  private String lastName;
  
  @Persistent(mappedBy = "owner")
  @Element(dependent = "true")  
  private List<Address> addresses;
  

  // empty constructor
  public Person() {
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Integer getVersion() {
    return version;
  }


  public void setVersion(Integer version) {
    this.version = version;
  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public List<Address> getAddresses() {
    return addresses;
  }


  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }
  
  


}
