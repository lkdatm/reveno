/**
 *  Copyright (c) 2015 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.reveno.atp.api.query;

import it.unimi.dsi.fastutil.longs.LongCollection;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface MappingContext {

	<V> V get(Class<V> viewType, long id);

	default <V> Optional<V> getO(Class<V> viewType, long id) {
		return Optional.ofNullable(get(viewType, id));
	}

	<V> List<V> link(long[] ids, Class<V> viewType);

	<V> Set<V> linkSet(long[] ids, Class<V> viewType);

	<V> List<V> link(Stream<Long> ids, Class<V> viewType);
	
	<V> Set<V> linkSet(Stream<Long> ids, Class<V> viewType);

	<V> List<V> link(LongCollection ids, Class<V> viewType);
	
	<V> Set<V> linkSet(LongCollection ids, Class<V> viewType);
	
	<V> Supplier<V> link(Class<V> viewType, long id);

}
