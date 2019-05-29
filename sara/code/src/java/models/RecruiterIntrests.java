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
import java.util.Objects;

/**
 * Manufacturer.java
 *
 * @since Apr 20, 2019
 */

public class RecruiterIntrests implements Serializable {


    private Long id;

    private Recruiters recruiters;

    private Interests interests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recruiters getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(Recruiters recruiters) {
        this.recruiters = recruiters;
    }

    public Interests getInterests() {
        return interests;
    }

    public void setInterests(Interests interests) {
        this.interests = interests;
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
        RecruiterIntrests recruiters = (RecruiterIntrests) o;
        return Objects.equals(id, recruiters.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RecruiterIntrests{" +
                "id=" + id +
                '}';
    }
}
