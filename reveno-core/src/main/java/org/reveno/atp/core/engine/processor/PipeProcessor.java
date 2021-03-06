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

package org.reveno.atp.core.engine.processor;

import org.reveno.atp.core.api.Destroyable;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@SuppressWarnings("unchecked")
public interface PipeProcessor<T extends Destroyable> {

	void start();
	
	void stop();
	
	void sync();
	
	void shutdown();
	
	boolean isStarted();
	
	PipeProcessor<T> pipe(ProcessorHandler<T>... handler);
	
	
	<R> CompletableFuture<R> process(BiConsumer<T, CompletableFuture<R>> consumer);
	
	
	default PipeProcessor<T> then(ProcessorHandler<T>... handler) {
		return pipe(handler);
	}

	long SYNC_FLAG = 0x111;
	
}
