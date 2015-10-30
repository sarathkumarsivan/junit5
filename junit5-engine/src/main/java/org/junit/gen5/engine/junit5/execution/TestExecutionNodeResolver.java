/*
 * Copyright 2015 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine.junit5.execution;

import org.junit.gen5.commons.util.Preconditions;
import org.junit.gen5.engine.EngineDescriptor;
import org.junit.gen5.engine.TestDescriptor;
import org.junit.gen5.engine.junit5.descriptor.ClassTestDescriptor;
import org.junit.gen5.engine.junit5.descriptor.MethodTestDescriptor;

/**
 * @author Stefan Bechtold
 * @author Sam Brannen
 * @since 5.0
 */
public class TestExecutionNodeResolver {

	public static TestExecutionNode forDescriptor(TestDescriptor testDescriptor) {
		Preconditions.notNull(testDescriptor, "testDescriptor must not be null");

		if (testDescriptor instanceof MethodTestDescriptor) {
			return new MethodTestExecutionNode((MethodTestDescriptor) testDescriptor);
		}
		else if (testDescriptor instanceof ClassTestDescriptor) {
			return new ClassTestExecutionNode((ClassTestDescriptor) testDescriptor);
		}
		else if (testDescriptor instanceof EngineDescriptor) {
			return new EngineTestExecutionNode((EngineDescriptor) testDescriptor);
		}

		// else
		throw new IllegalArgumentException("Unsupported TestDescriptor type: " + testDescriptor.getClass().getName());
	}

}
