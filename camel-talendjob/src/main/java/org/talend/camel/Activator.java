/*
 * #%L
 * Camel Talend Job Component
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

package org.talend.camel;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    private static BundleContext context;

    @Override
    public void start(BundleContext context) throws Exception {
        Activator.context = context;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        Activator.context = null;
    }

    public static <T> T getJobService(Class<T> clazz, String fullJobName) {
        if (context != null) {
            try {
            	String clazzName = clazz.getName();
            	String simpleName = fullJobName.substring(fullJobName.lastIndexOf('.') + 1);
            	/*
            	 * read old version style first
            	 * see https://jira.talendforge.org/browse/TESB-12909
            	 */
            	ServiceReference serviceReference = null;
                ServiceReference[] serviceReferences = context.getServiceReferences(clazzName, "(&(name=" + simpleName + ")(type=job))");

                //if no old version style, then read fashion style
                if(null == serviceReferences){
                	serviceReferences = context.getServiceReferences(clazzName, "(&(name=" + fullJobName + ")(type=job))");
                }
                
                if (null != serviceReferences && serviceReferences.length != 0) {
                	serviceReference = serviceReferences[0];
                }
                
                Object service = context.getService(serviceReference);
                return clazz.cast(service);
            } catch (InvalidSyntaxException e) {
            }
        }
        return null;
    }

}
