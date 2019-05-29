/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Manufacturer.java
 *
 * @since Apr 20, 2019
 */

public class RecruiterAddresses implements Serializable {

    private static final long serialVersionUID = 3847835937208411398L;

    private Integer id;
    private Recruiters recruiters;
    private Country country;
    private City city;

    private String neighbourhood;

    private String street;

    private String buildingOfficeDetails;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recruiters getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(Recruiters recruiters) {
        this.recruiters = recruiters;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingOfficeDetails() {
        return buildingOfficeDetails;
    }

    public void setBuildingOfficeDetails(String buildingOfficeDetails) {
        this.buildingOfficeDetails = buildingOfficeDetails;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RecruiterAddresses recruiters = (RecruiterAddresses) o;
        return Objects.equals(id, recruiters.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecruiterAddresses{" +
                "id=" + id +
                '}';
    }
}
