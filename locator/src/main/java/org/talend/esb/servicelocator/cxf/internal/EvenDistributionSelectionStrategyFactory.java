/*
 * #%L
 * Even Distribution Service Locator Selection Strategy
 * %%
 * Copyright (C) 2011 - 2012 Talend Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.talend.esb.servicelocator.cxf.internal;


/**
 * Creates an EvenDistributionSelectionStrategy instance, which
 * performs a client side round robin strategy. 
 * In case of a fail over all strategies are equivalent.
 * A random alternative endpoint is selected. 
 * If multiple clients use EvenDistributionSelectionStrategy it
 * could happen that all clients choose subsequently the same endpoints since the locator
 * instances for each client operate independently. RandomSelectionStrategy avoids this
 * problem.
 */

public class EvenDistributionSelectionStrategyFactory implements LocatorSelectionStrategyFactory {

	private int reloadAddressesCount = 10;

	public void setReloadAddressesCount(int reloadAddressesCount) {
	    this.reloadAddressesCount = reloadAddressesCount;
	}

	@Override
	public LocatorSelectionStrategy getInstance() {
		EvenDistributionSelectionStrategy strategy = new EvenDistributionSelectionStrategy();
		strategy.setReloadAddressesCount(reloadAddressesCount);
		return strategy;
	}

}
