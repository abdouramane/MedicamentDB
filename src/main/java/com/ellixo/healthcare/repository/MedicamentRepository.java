/*
 * Open Medicaments
 * Copyright (C) 2015  Ellixo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ellixo.healthcare.repository;

import com.ellixo.healthcare.domain.Medicament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MedicamentRepository extends ElasticsearchRepository<Medicament, String> {

    @Query("{" +
            "        \"match_phrase_prefix\": {" +
            "            \"_all\": {" +
            "                \"query\": \"?0\"," +
            "                \"slop\": 1000," +
            "                \"fuzziness\": 1" +
            "            }" +
            "        }" +
            "    }")
    Page<Medicament> searchAll(String criteria, Pageable pageable);
}
